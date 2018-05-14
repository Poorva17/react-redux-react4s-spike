import {combineReducers} from 'redux';
import comments from './CommentsReducer'

const rootReducer = combineReducers({
  comments
});

export default rootReducer;