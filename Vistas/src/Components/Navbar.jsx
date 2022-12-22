import React from 'react'
import {Link} from "react-router-dom";
import { GlobalContext } from './utils/global.context';
//Este componente debera ser estilado como "dark" o "light" dependiendo del theme del Context

const Navbar = () => {

  const {theme,dispath} = GlobalContext()

  return (
    <nav className='nav'>
      <Link to ="/">Home</Link>      
      <Link to ="Pacientes">Pacientes</Link>
      <Link to ="Usuario">Usuarios</Link>
      <Link to={`Odontologo`}>Odontologo</Link>
      <Link to ="turnos">turnos</Link>
      {/* Aqui deberan agregar los liks correspondientes a las rutas definidas */}
      {/* Deberan implementar ademas la logica para cambiar de Theme con el button */}
      <button onClick={()=>dispath({  type:'change_theme'})}>Change theme</button>
    </nav>
  )
}

export default Navbar