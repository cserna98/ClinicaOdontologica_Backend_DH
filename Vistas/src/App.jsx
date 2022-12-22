
import { Route,Routes } from "react-router-dom";
import Footer from "./Components/Footer";
import Navbar from "./Components/Navbar";
import Home from "./Routes/Home"
import Odontologo from "./Routes/Odontologo"
import Pacientes from "./Routes/Pacientes"
import Usuario from "./Routes/Usuario"
import { GlobalContext } from './Components/utils/global.context'
import Turnos from "./Routes/Turnos";


function App() {
  const {theme} = GlobalContext() 

  return ( 
    <div className={`app ${theme}`} >
    <Navbar/>
    <Routes>
      <Route path="/" element={<Home></Home>}/>
        <Route path="/Odontologo" element={<Odontologo></Odontologo>}/>
        <Route path="/Pacientes" element={<Pacientes></Pacientes>}/>
        <Route path="/Usuario" element={<Usuario></Usuario>}/>
        <Route path="/turnos" element={<Turnos></Turnos>}/>        
    </Routes>    
    <Footer/>
    </div>
      
  );
}

export default App;
