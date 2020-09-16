import React from 'react';
import { useState } from "react";
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome';
import { faTrash, faAt } from "@fortawesome/free-solid-svg-icons";
import Todo from './Todo.js';
import Header from './Header.js';
import TodoForm from './TodoForm.js';

function TodoApp() {
    const [todos, setTodos] = useState([]);
  
    //Adds Todo
    const addTodo = text => {
      const newTodos = [...todos, { isCompleted:false,text }];
      setTodos(newTodos);
    };
  
    //Checks the todo as completed if not and not if completed
    const checkTodo = index => {
      const newTodos = [...todos];
      if(newTodos[index].isCompleted){
        newTodos[index].isCompleted = false;
      }else{
      newTodos[index].isCompleted = true;
      }
      setTodos(newTodos);
    };
  
    //Removes todo by index
    const removeTodo = index => {
      const newTodos = [...todos];
      newTodos.splice(index, 1);
      setTodos(newTodos);
    };
  
    //Deletes completed todos
    const deleteCompleted = () => {
      const newTodos = todos.filter(todo => !todo.isCompleted);
      setTodos(newTodos);
    }
  
    return (
      <div className="container">
        <Header/>
        <div className="content">
          <ul id="list">
          {todos.map((todo, index) => (
            <Todo
              key={index}
              index={index}
              todo={todo}
              checkTodo={checkTodo}
              removeTodo={removeTodo}
              isCompleted={todo.isCompleted}
            />
          ))}
          </ul>
        </div>
        <TodoForm addTodo={addTodo}/>
        <div className="filter-buttons">
        <div className="card">
        <FontAwesomeIcon icon={faTrash}/>
        <label className="delete-completed" onClick={deleteCompleted}>Delete completed</label>
        </div>
        <div className="card author">
        <FontAwesomeIcon icon={faAt}/>
        <label>Borislav Arangelov</label>
        </div>
        </div>
      </div>
    );
  }
  export default TodoApp;