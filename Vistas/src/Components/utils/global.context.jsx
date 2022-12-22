import { useContext,useEffect,useReducer,createContext, useState} from "react";






// Usecontext
export const ContextGlobal = createContext();
export const initialState = "light" 

export const ContextProvider = ({children}) => {
  // usereducer para cambiar el valor del tema
  const[theme,dispath]= useReducer((state, action)=>{
    console.log(state)      
    return    state === "light" ? "dark" : "light" ;
  },initialState)  

  // useEffect para cargar la funcion asincronica que trae los datos de la api
  useEffect(()=>{
    getdataApi()
    console.log(dentists) 
    console.log(user)    
  },[])
  // usestate para guardar la api en un estado.
  const [dentists,setUser] = useState([])
  // funcion asincronica que trae datos de la api
  async function getdataApi(){
    const settings = {
      method: 'GET'
    } 
    let response = await fetch("http://localhost:8080/api/odontologos",settings);
    console.log(response)
    let dentists = await response.json();
    console.log(dentists)           
  };

  const [user,SetUser] = useState("inicial");

  return (
    <ContextGlobal.Provider value={{dispath,dentists,user,SetUser}}>
      {children}
    </ContextGlobal.Provider>
  );
};

export const GlobalContext= ()=> useContext(ContextGlobal)