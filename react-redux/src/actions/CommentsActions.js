import {ADD_COMMENT} from "./CommentsActionTypes";

export const addComment = (newComment) => ({
  type: ADD_COMMENT,
  data: newComment
});