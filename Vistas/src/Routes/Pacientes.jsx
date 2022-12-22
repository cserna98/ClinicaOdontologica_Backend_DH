import React from "react";
import Card from "../Components/CardDentist";
import { useState,useEffect } from "react";
import { GlobalContext } from '../Components/utils/global.context'
import CardPaciente from "../Components/CardPaciente";
import FormPaciente from "../Components/utils/FormPaciente";
import '../Components/utils/styles/form.css'

//Este componente debera ser estilado como "dark" o "light" dependiendo del theme del Context

const Favs = () => {
  const {user,SetUser} = GlobalContext()  
  const [Paciente,SetPaciente] = useState([])

  const [showForm, setShowForm] = useState(false);

  function handleButtonClick() {
    setShowForm(!showForm);
  }

  async function getpaciente(){
    const settings = {
      method: 'GET'
    } 
    let response = await fetch("http://localhost:8080/api/pacientes",settings);
    console.log(response)
    let pacientes = await response.json();
    SetPaciente(pacientes)       
  };

  async function putPaciente(){
    const url = 'http://localhost:8080/api/pacientes';
        const settings = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify("")
        }

    let response = await fetch(url,settings);
    console.log(response)
    let pacientes = await response.json();
    SetPaciente(pacientes)       
  }

  async function deleteBy(id){
    const url='/pacientes/'+id;
    const settings={
        method: 'DELETE'
    }
    let response = await fetch("http://localhost/pacientes",settings);
    console.log(response)
    let pacientes = await response.json();
    SetPaciente(pacientes)               
}

useEffect(()=>{
  getpaciente()
  SetUser("paciente")  
  console.log(user)
  console.log(Paciente)
},[])

  return (
    <>      
      <div className="render">
        {showForm ? (
        <FormPaciente/>        
        ) : (
      <div className="card-grid">        
        {Paciente.map((e)=>(<CardPaciente key={e.id} paciente={e} user={user}></CardPaciente>))}
      </div>
      )}
      <button className="agregar" onClick={handleButtonClick}>Agregar</button>       
      </div>
      
    </>
  );
};

export default Favs;
