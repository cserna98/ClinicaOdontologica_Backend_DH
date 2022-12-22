import React, { useState, useRef } from 'react';

function Form() {
  const [matricula, setMatricula] = useState('');
  const [nombre, setNombre] = useState('');
  const [apellido, setApellido] = useState('');
  const matriculaInput = useRef(null);
  const nombreInput = useRef(null);
  const apellidoInput = useRef(null);

  async function handleSubmit(event) {
    event.preventDefault();

    // create the object to send in the request body
    const data = {
      matricula: matriculaInput.current.value,
      nombre: nombreInput.current.value,
      apellido: apellidoInput.current.value,
    };

    // send the POST request to the API
    const response = await fetch('http://localhost:8080/api/odontologos', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(data),
    });

    // check the response status
    if (response.ok) {
      // the request was successful, do something with the response data
      const result = await response.json();
      console.log(result);
    } else {
      // there was an error, handle it here
      console.error(response.statusText);
    }
  }

  return (
    <div className="form-container Add">
      <form onSubmit={handleSubmit}>
        <label htmlFor="matricula">Matricula</label>
        <input
          type="text"
          id="matricula"
          name="matricula"
          className="form-input"
          ref={matriculaInput}
        />

        <label htmlFor="nombre">Nombre</label>
        <input
          type="text"
          id="nombre"
          name="nombre"
          className="form-input"
          ref={nombreInput}
        />

        <label htmlFor="apellido">Apellido</label>
        <input
          type="text"
          id="apellido"
          name="apellido"
          className="form-input"
          ref={apellidoInput}
          />
          <input type="submit" value="Enviar" className="form-button" />
          </form>
        </div>
      );
    }
    
    export default Form;