import React, { Component } from 'react';


class ToDo extends Component {



    constructor(props) {
        super(props);
        this.state = {
            list: "",
            arr: [],
            status : false
        }
    }

    handInp = (ele) => {
        this.setState({
            list: ele.target.value
        })
    }

    addItem = () => {
        let outlet = this.state.arr;
        outlet.push(this.state.list);
        this.setState({
            arr: outlet
        })
    }


  

    delList = (pi) => {
        let letDel = [...this.state.arr];
        letDel.splice(pi, 1);
        this.setState(
            {
                arr: letDel
            }
        )

    }

    render(props) {

        const upd = this.state.arr.map((ele, pi) => {
            return (
                <p key={pi}  onClick={() => this.delList(pi)} >{ele}</p>

                
            );
        })
        
        return (
            <div>
                <input type="text" name="t1" id="t1" onChange={(ele) => { this.handInp(ele) }} placeholder="Add Item" />

                <button onClick={() => { this.addItem() }}>ADD</button>
                {upd}

            </div>
        );

    }

}

export default ToDo;