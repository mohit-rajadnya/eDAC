import './App.css';
import React, {Component} from 'react'; 
import Header from './NewsHeader/Header'
import Content from './NewsContent/Content'
import EmpData from './EmpData/EmpData'
import Emp from './EmpData/EmpData';
import Skill from './SkillSet/Skillsets';
import Todo from './Todolist/Todo'

class App extends Component {

  /* ***Question no.3 
  state = {
    Emp:[
      {
        "EmpID":101,
        "EmpName":"Mohit",
        "Salary":20000
      },
      {
          "EmpID":102,
          "EmpName":"Raju",
          "Salary":15000
      },
      {
          "EmpID":103,
          "EmpName":"Donald",
          "Salary":25000
      },
      {
          "EmpID":101,
          "EmpName":"Putin",
          "Salary":1000
      }
    ]
  } */

  

  render(){

  return (

    <div >
    <Emp />
    <Skill >
      <p>NodeJS</p>
      <p>ReactJS</p>
      <p>Angular</p>
      <p>Mongo DB </p>
    </Skill>


    <h1>To-Do-List</h1>
    <Todo />

    </div>

      /* <div>
            <h1 className="App">Employee Data</h1>
            <table className='table table-dark table-striped'>
                  <EmpData ID={this.state.Emp[0].EmpID} 
                            Name={this.state.Emp[0].EmpName} 
                            Salary={this.state.Emp[0].Salary}/>
                  <EmpData ID={this.state.Emp[1].EmpID} 
                            Name={this.state.Emp[1].EmpName} 
                            Salary={this.state.Emp[1].Salary}/>
                  <EmpData ID={this.state.Emp[2].EmpID} 
                            Name={this.state.Emp[2].EmpName} 
                            Salary={this.state.Emp[2].Salary}/>
                  <EmpData ID={this.state.Emp[3].EmpID} 
                            Name={this.state.Emp[3].EmpName} 
                            Salary={this.state.Emp[3].Salary}/>
                   
                  
            </table>
      </div> */


      /* <div className="container-fluid">
        <div className="row">
            <div className="col-12">
                <Header/>
            </div>

            <div className="col-md-4 col-12">
                <Content subheading = "MP moves HC for ‘English only’ communication between Centre and State" 
                  article = "Madurai Member of Parliament Su. Venkatesan on Friday moved the Madurai Bench of the Madras High Court, seeking a direction to the Centre to ensure that all communications between the Centre and Tamil Nadu were in English alone. Mr. Venkatesan, who represents the CPI (M),was upset over a reply sent to him in Hindi by Union Minister of State for Home Affairs Nityanand Rai recently." 
                  />
            </div>
        <br/>
            <div className="col-md-4 col-12">
                <Content subheading = "MP moves HC for ‘English only’ communication between Centre and State" 
                  article = "Madurai Member of Parliament Su. Venkatesan on Friday moved the Madurai Bench of the Madras High Court, seeking a direction to the Centre to ensure that all communications between the Centre and Tamil Nadu were in English alone. Mr. Venkatesan, who represents the CPI (M),was upset over a reply sent to him in Hindi by Union Minister of State for Home Affairs Nityanand Rai recently." 
                  />
            </div>
        <br/>
            <div className="col-md-4 col-12">
                <Content subheading = "MP moves HC for ‘English only’ communication between Centre and State" 
                  article = "Madurai Member of Parliament Su. Venkatesan on Friday moved the Madurai Bench of the Madras High Court, seeking a direction to the Centre to ensure that all communications between the Centre and Tamil Nadu were in English alone. Mr. Venkatesan, who represents the CPI (M),was upset over a reply sent to him in Hindi by Union Minister of State for Home Affairs Nityanand Rai recently." 
                  />
            </div>
        </div>
      </div> */

   
  );
}
}

export default App;