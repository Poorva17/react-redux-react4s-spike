package samples.r4s

import com.github.ahnfelt.react4s.{Attachable, Component, Get, Signal}

import scala.collection.mutable

abstract class GlobalStore[S](initialValue: S) {
  type Msg

  private val listeners   = mutable.HashSet[Component[_]]()
  private var storedValue = initialValue

  def onEmit(message: Msg, currentValue: S): S

  def emit(message: Msg): Unit = {
    storedValue = onEmit(message, storedValue)
    for (listener <- listeners) listener.update()
  }

  def apply(component: Component[_]): Signal[S] =
    component.attach(new Signal[S] with Attachable {
      listeners += component
      override def componentWillUnmount(get: Get): Unit = listeners -= component
      override def sample(get: Get): S                  = storedValue
    })
}
