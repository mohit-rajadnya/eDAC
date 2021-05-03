import React from 'react';

const skillset = (props)=>
{
    const skillArr = props.children.map(ele => 
    {
        return (<li>{ele}</li>);
    });

    return(

        <div>
            <ol>
                {skillArr}
            </ol>
        </div>
    )
}

export default skillset;