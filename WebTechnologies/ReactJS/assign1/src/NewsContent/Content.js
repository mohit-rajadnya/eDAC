import React from 'react';
import '../News.css';

const content = (props) => 
{
    return(
        <div className= 'News' style={{backgroundColor:'beige'}}>
            <h3>{props.subheading}</h3>
            <p>{props.article}</p>
            
        </div>
    );
}
export default content;