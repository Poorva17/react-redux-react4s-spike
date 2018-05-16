package samples

import com.github.ahnfelt.react4s.{Attachable, Component, Get, Signal}

import scala.collection.mutable

abstract class GlobalStore[M, S](initialValue: S) {

  private val listeners   = mutable.HashSet[Component[_]]()
  private var storedValue = initialValue

  def onEmit(message: M, currentValue: S): S

  def emit(message: M): Unit = {
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
