package com.example.ejercicionavigationcomponentobjeto;

import android.os.Parcel;
import android.os.Parcelable;

//Definimos la clase Persona
public class Persona implements Parcelable {
    //Declaramos los diferentes atributos que tiene esta clase
    private String nombre;
    private String apellidos;
    private Integer telefono;

    //Declaramos un constructor con los diferentes atributos
    public Persona(String nombre, String apellidos, Integer telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
    }

    //Declaramos un contructor vacio
    public Persona() {
    }

    //Generamos los getter y los setter de todos los atributos
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Integer getTelefono() {
        return telefono;
    }
    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    //Generamos el metodo toString que sirve para mostrar los atributos de la persona
    @Override
    public String toString() {
        return "Persona {" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", telefono=" + telefono +
                '}';
    }

    //Sirve para leer los atributos del objeto Persona
    protected Persona (Parcel in) {
        nombre = in.readString();
        apellidos = in.readString();
        if (in.readByte() == 0) {
            telefono = null;
        } else {
            telefono = in.readInt();
        }
    }

    //Parcelable tiene que tener un campo estatico no nulo
    public static final Creator<Persona> CREATOR = new Creator<Persona>() {
        @Override
        public Persona createFromParcel(Parcel in) {
            return new Persona(in);
        }

        @Override
        public Persona[] newArray(int size) {
            return new Persona[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    //Aplana el objeto Persona en una parcela, escribir el objeto en una parcela
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nombre);
        parcel.writeString(apellidos);
        if (telefono == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(telefono);
        }
    }
}
