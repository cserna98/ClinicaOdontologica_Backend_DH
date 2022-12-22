import React, { useState } from 'react';

function FormPaciente() {
  const [formData, setFormData] = useState({
    lastName: '',
    name: '',
    email: '',
    dni: '',
    date: '',
    calle: '',
    number: '',
    localidad: '',
    provincia: '',
    email: '',
  });

  async function handleSubmit(event) {
    event.preventDefault();

    // create the object to send in the request body
    const data = {
      ...formData,
      domicilio: {
        calle: formData.calle,
        number: formData.number,
        localidad: formData.localidad,
        provincia: formData.provincia,
      },
    };

    // send the POST request to the API
    const response = await fetch('http://example.com/api/pacientes', {
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

  function handleChange(event) {
    setFormData({ ...formData, [event.target.name]: event.target.value });
  }

  return (
    <div className="form-container">
      <form onSubmit={handleSubmit}>
        <label htmlFor="lastName">Apellido</label>
        <input
          type="text"
          id="lastName"
          name="lastName"
          className="form-input"
          value={formData.lastName}
          onChange={handleChange}
        />

        <label htmlFor="name">Nombre</label>
        <input
          type="text"
          id="name"
          name="name"
          className="form-input"
          value={formData.name}
          onChange={handleChange}
        />

        <label htmlFor="email">Email</label>
        <input
          type="text"
          id="email"
          name="email"
          className="form-input"
          value={formData.email}
          onChange={handleChange}
        />

        <label htmlFor="dni">DNI</label>
        <input
          type="text"
          id="dni"
          name="dni"
          className="form-input"
          value={formData.dni}
          onChange={handleChange}
        />

        <label htmlFor="date">Fecha</label>
        <input
          type="date"
          id="date"
          namclassName="form-input"
          value={formData.calle}
          onChange={handleChange}
        />

        <label htmlFor="number">Número</label>
        <input
          type="text"
          id="number"
          name="number"
          className="form-input"
          value={formData.number}
          onChange={handleChange}
        />

        <label htmlFor="localidad">Localidad</label>
        <input
          type="text"
          id="localidad"
          name="localidad"
          className="form-input"
          value={formData.localidad}
          onChange={handleChange}
        />

        <label htmlFor="provincia">Provincia</label>
        <input
          type="text"
          id="provincia"
          name="provincia"
          className="form-input"
          value={formData.provincia}
          onChange={handleChange}
        />

        <label htmlFor="email">Email</label>
        <input
          type="text"
          id="email"
          name="email"
          className="form-input"
          value={formData.email}
          onChange={handleChange}
        />

        <button type="submit" className="form-submit-button">
          Enviar
        </button>
      </form>
    </div>
  );
}

export default FormPaciente;