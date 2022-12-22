import React from "react";
import { GlobalContext } from "./utils/global.context";

const Card = ({dentist}) => {         
       
     // Aqui iria la logica para agregar la Card en el localStorage   

  return (    
    <div className="card">        
    <img src="../images/doctor.jpg" id="imgDoctor"/>
    <h4>{dentist.matricula}</h4>
    <h4>{dentist.nombre}</h4>
    <h4>{dentist.apellido}</h4>       
</div>    
  );
};

export default Card;
