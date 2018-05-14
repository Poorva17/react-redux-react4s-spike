import {ADD_COMMENT} from "../actions/CommentsActionTypes";

const initialState = []

export default function (state = initialState, action) {
  switch (action.type) {
    case ADD_COMMENT:
      return [...state, action.data]

    default:
      return state;
  }
}