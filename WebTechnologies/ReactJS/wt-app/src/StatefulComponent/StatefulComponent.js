import React , {Component} from 'react';


class StatefulComponent extends Component
{
    state={
        name:"mohit",
        age:23,
        address:"mah"
    }
    render()
    {
        return(
            <div>
                <h3>Name: {this.state.name} </h3>
                <h3>Age:  {this.state.age} </h3>
                <h3>Address:  {this.state.address} </h3>
            </div>
        );
    }
}
export default StatefulComponent;