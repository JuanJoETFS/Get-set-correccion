public class Persona {
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private char sexo;
    private int edad;
    private String direccion;

    // Constructor por defecto
    public Persona() {
    }

    // Constructor de copia
    public Persona(Persona persona) {
        this.nombre = persona.nombre;
        this.apellidoPaterno = persona.apellidoPaterno;
        this.apellidoMaterno = persona.apellidoMaterno;
        this.sexo = persona.sexo;
        this.edad = persona.edad;
        this.direccion = persona.direccion;
    }

    // Constructor común
    public Persona(String nom, String app, String apm, char sexo, int edad, String dir) {
        this.nombre = nom;
        this.apellidoPaterno = app;
        this.apellidoMaterno = apm;
        this.sexo = sexo;
        this.edad = edad;
        this.direccion = dir;
    }

    public void mayorEdad(int edad) {
        if (edad >= 18) {
            System.out.println("Es mayor de edad");
        } else {
            System.out.println("Es menor de edad");
        }
    }

    public String mostrarDatos(Persona persona) {
        String datos = "Los datos son: \n";
        datos += "Nombre: " + persona.nombre + "\n";
        datos += "Apellido Paterno: " + persona.apellidoPaterno + "\n";
        datos += "Apellido Materno: " + persona.apellidoMaterno + "\n";
        datos += "Sexo: " + persona.sexo + "\n";
        datos += "Edad: " + persona.edad + "\n";
        datos += "Direccion: " + persona.direccion + "\n";
        return datos;
    }

    // Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }
public void setDireccion(String direccion) {
    this.direccion = direccion;
}

// Método creativo: Genera un apodo basado en el nombre y apellidos
public String generarApodo() {
    if (nombre != null && apellidoPaterno != null && nombre.length() >= 2 && apellidoPaterno.length() >= 2) {
        String parteNombre = nombre.substring(0, 2);
        String parteApellido = apellidoPaterno.substring(apellidoPaterno.length() - 2);
        return parteNombre + parteApellido;
    }
    return "Apodo no disponible";
}
}
