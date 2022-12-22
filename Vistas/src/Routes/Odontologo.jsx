import React from 'react'
import { useContext,useState } from 'react';
import { useParams } from "react-router-dom";
import { useEffect } from 'react';
import Turnos from './Turnos'
import Card from '../Components/CardDentist';
import { GlobalContext } from '../Components/utils/global.context'
import FormOdonto from '../Components/FormOdonto';


//Este componente debera ser estilado como "dark" o "light" dependiendo del theme del Context

const Odontologo = () => {

  const params= useParams();
  const {user,SetUser} = GlobalContext() 
  
  // Consumiendo el parametro dinamico de la URL deberan hacer un fetch a un user en especifico
  const [dentist,setdentist] = useState([]) ;

  async function postOdontologo(){
    const url = 'http://localhost:8080/odontologos';
        const settings = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify("")
        }
        let response = await fetch(url, settings);  
        let dentist = await response.json();
        setdentist(dentist)     
        console.log(dentist)  

  }

  const [showForm, setShowForm] = useState(false);

  function handleButtonClick() {
    console.log("holi me clikeaste")
    setShowForm(!showForm);
  }

  
  async function getdentist(){
    const settings = {
      method: 'GET'
    } 
    let response = await fetch("http://localhost:8080/api/odontologos",settings);
    console.log(response)
    let dentists = await response.json();
    setdentist(dentists)         
  };

useEffect(()=>{
  SetUser("odonto")  
  console.log(user)
  getdentist()
},[])

  

  return (
    <>
    <div className="render">
        {showForm ? (
        <FormOdonto/>        
        ) : (
      <div className="card-grid">        
        {dentist.map((e)=>(<Card key={e.id} dentist={e} ></Card>))}
      </div>
      )}
      <button className="agregar" onClick={handleButtonClick}>Agregar</button>       
      </div>     
      
    </>
  )
}

export default Odontologo