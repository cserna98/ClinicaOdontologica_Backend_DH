import { useEffect,useState } from 'react';


const Turnos = () => {
    
  const [turnos,setTurnos] = useState([]);
    async function getturno(){
        const settings = {
          method: 'GET'
        } 
        let response = await fetch("http://localhost:8080/api/turnos",settings);
        console.log(response)
        let turno = await response.json();
        setTurnos(turno)       
      };
    useEffect(()=>{
      getturno()
      console.log(turnos) 
         
    },[])
    
    return (
      <div>
        
       holi
      </div>
    )
  }
  
  export default Turnos