import React from "react";
import { GlobalContext } from "./utils/global.context";


const CardPaciente = ({paciente}) => {           
       const user = GlobalContext(); 
     // Aqui iria la logica para agregar la Card en el localStorage   
    

  return (    
    <div className="card">        
    <img src="../images/doctor.jpg" id="imgDoctor"/>
    <h4>{paciente.name}</h4>
    <h4>{paciente.lastName}</h4> 
    <h4>{paciente.email}</h4>          
</div>    
  );
};

export default CardPaciente;
