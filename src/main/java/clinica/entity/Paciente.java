package clinica.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pacientes")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //Paciente (ID, Apellido, Nombre, Email, DNI, Fecha ingreso)
//● Domicilio (Calle, Número, Localidad, Provincia)
    @Column
    private String lastName;
    @Column
    private String name;
    @Column(unique = true)
    private String Email;
    @Column
    private String dni;
    @Column
    private LocalDate date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Paciente(Long id, String lastName, String name, String email, String dni, LocalDate date) {
        this.id = id;
        this.lastName = lastName;
        this.name = name;
        Email = email;
        this.dni = dni;
        this.date = date;
    }

    public Paciente(String lastName, String name, String email, String dni, LocalDate date) {
        this.lastName = lastName;
        this.name = name;
        Email = email;
        this.dni = dni;
        this.date = date;
    }

    public Paciente() {

    }
}
