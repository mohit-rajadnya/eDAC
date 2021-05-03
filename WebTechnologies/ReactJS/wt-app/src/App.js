import logo from './logo.svg';
import React , {Component} from 'react';
import './App.css';
import Person from "./Person/Person";
import NewPerson from "./NewPerson/NewPerson";

class App extends Component {

  state=
    {
        showPersons:false,
        persons:[
          {Name:"Shri" , age:20},
          {Name:"Amir" ,  age:25},
          {Name:"Mohit", age:24}
        ]
    }

    btnHandler = (newName) =>
    {
      this.setState({
        uname: '' ,
        persons:[
          {Name:"Shrilata" , age:20},
          {Name:"Amir" ,  age:25},
          {Name:"Mohit", age:30}
        ]
      })
    }
    inputHandler = (event) =>
    {
        this.setState({uname:event.target.value});
    }

    inputHandler1 = (event) =>
    {
      this.setState({
        persons:[
          {Name:"Shri" , age:20},
          {Name:event.target.value ,  age:25},
          {Name:"Mohit", age:24}
        ]
      })
    }

    togglehandler = () =>
    {
        const doesShow = this.state.showPersons;
        this.setState({showPersons:!doesShow});
    }
    // inputHandler2 = (event){

    // }
  render(){

    let persons = null;
    if(this.state.showPersons){
      persons = (
        <div>
          {/* <Person /> */}
          <NewPerson name = {this.state.persons[0].Name}  
                    age = {this.state.persons[0].age}> 
          <p>Hobbies : Coding</p>
          <p>Hobbies : Sleeping </p>
          </NewPerson>
          <NewPerson
              name = {this.state.persons[1].Name}  
              age = {this.state.persons[1].age}
              // click={() => this.btnHandler("Savita")}
              change = {this.inputHandler1}>
          </NewPerson>
          <NewPerson name = {this.state.persons[2].Name}  
                    age = {this.state.persons[2].age}/> 
      </div>
      )
    }
    // Just call {persons into return to display the content and hide too}
    //Working with lists

    // const nums = [1,2,3,4,5];
    // const updatednums = nums.map(num => {
    //   return <li>{num}</li>
    // });

    // const items = [{name:"item1"},{name:"item2"},{name:"item3"}]
    // const itemsupdated = items.map(item => {
    //       return <p>{item.name}</p>
    // });

    // const students = [
    //   {name: " shubhangi" , age:20},
    //   {name: " Nikhil" , age:30},
    //   {name: " Bhavesh" , age:50},

    // ]
    // const studentupdated = students.map(student => (

    //   <tr>
    //     <td>{student.name}</td>
    //     <td>{student.age}</td>
    //   </tr>
    // ))
      //Paranthesis implicitly return value from function ****only in react***


   const btnStyle = 
   {
      backgroundColor: 'blue',
      color:'white',
      font:'inherit',
      border:'5px solid blue'

   }

   return(
     //className is converted into class inside browser
   <div className = "App">  
      <h1>Welcome to react</h1>
      {/* Name: <input value={this.state.uname} onChange={this.inputHandler}></input>
      Hello - {this.state.uname}
    <br/> <br/>
 */}
        {/* {updatednums}
        <br/>
        {itemsupdated}
        <br/>
        <table border="1px">
            {studentupdated}
        </table> */}

      {/* <button onClick={this.btnHandler.bind(this,"Kavita")} /* style={btnStyle} class="btn btn-primary" >
        Switch name
      </button> */}

      <button onClick={this.togglehandler} /* style={btnStyle} */ class="btn btn-primary" >
        Switch name
      </button>

      {this.state.showPersons ? 

      <div>
          {/* <Person /> */}
          <NewPerson name = {this.state.persons[0].Name}  
                    age = {this.state.persons[0].age}> 
          <p>Hobbies : Coding</p>
          <p>Hobbies : Sleeping </p>
          </NewPerson>
          <NewPerson
              name = {this.state.persons[1].Name}  
              age = {this.state.persons[1].age}
              // click={() => this.btnHandler("Savita")}
              change = {this.inputHandler1}>
          </NewPerson>
          <NewPerson name = {this.state.persons[2].Name}  
                    age = {this.state.persons[2].age}/> 
      </div> : null}
   
    </div>
    

    ); 
    /*return React.createElement("div" , {className : 'App'} ,
            React.createElement("h1" , null , "Welcome to HTML"));*/
   }
}

export default App;
