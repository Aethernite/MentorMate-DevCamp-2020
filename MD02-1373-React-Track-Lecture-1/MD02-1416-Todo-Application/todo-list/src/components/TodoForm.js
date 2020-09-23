import React from 'react';
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome';
import {faPlusCircle} from "@fortawesome/free-solid-svg-icons";
import { useState } from "react";

function TodoForm({ addTodo }) {
    const [value, setValue] = useState("");
  
    const handleSubmit = e => {
      e.preventDefault();
      if (!value) return;
      addTodo(value);
      setValue("");
    };
  
    return (
      <div className="add-to-do">
      <form onSubmit={handleSubmit}>
        <FontAwesomeIcon icon={faPlusCircle} onClick={handleSubmit}/>
        <input
          type="text"
          className="input"
          value={value}
          placeholder="Add a to-do"
          maxLength="20"
          onChange={e => setValue(e.target.value)}
        />
      </form>
      </div>
    );
  }

  export default TodoForm;