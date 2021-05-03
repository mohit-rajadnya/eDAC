import React from 'react';
import './NewPerson.css';

const newperson = (props) => 
{
    

    return (
    <div className="NewPerson">
    <p onClick={props.click}>
        Hi , I am {props.name} and I am {props.age} years old.
    </p>
    
    <li>{props.children}</li>
    
    <input 
        onChange={props.change} value={props.name}>
    </input>
    </div>
    );
// Dynamic content is written inside {}
}
export default newperson;