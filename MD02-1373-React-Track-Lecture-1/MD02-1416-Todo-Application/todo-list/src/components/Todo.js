import React from 'react';
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome';
import {faCircleNotch, faTrash, faCheckCircle, faEdit} from "@fortawesome/free-solid-svg-icons";
import EditableLabel from 'react-inline-editing';
import { useRef } from "react";

function Todo({todo , index, checkTodo, removeTodo}){
    const inputRef = useRef(null);
  
    const focusInput = () => {
      inputRef.current._handleFocus();
    };
  
    return(
    <li className="item">
      <FontAwesomeIcon icon={todo.isCompleted? faCheckCircle : faCircleNotch} onClick={() => checkTodo(index)}/>
      <EditableLabel text={todo.text}
                  labelClassName={todo.isCompleted?"text lineThrough" : "text"}
                  inputClassName='edit-field'
                  inputHeight='25px'
                  inputMaxLength='20'
                  ref={inputRef}
                  />
      <FontAwesomeIcon icon={faEdit} onClick={focusInput}/>
      <FontAwesomeIcon icon={faTrash} onClick={() => removeTodo(index)}/>
    </li>
    )
  }
  
  export default Todo;