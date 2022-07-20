package logico;

//Clase Fecha Java
public class Fecha {

  private int dia;
  private int mes;
  private int anio;

  //Constructor por defecto
  public Fecha() {
  }

  //Constructor con parámetros
  public Fecha(int dia, int mes, int anio) {
      this.dia = dia;
      this.mes = mes;
      this.anio = anio;
  }

  //setters y getters
  public void setDia(int d) {
      dia = d;
  }
  public void setMes(int m) {
      mes = m;
  }
  public void setanio(int a) {
      anio = a;
  }
  public int getDia() {
      return dia;
  }
  public int getMes() {
      return mes;
  }
  public int getanio() {
      return anio;
  }

  //Método para comprobar si la fecha es correcta
  public boolean fechaCorrecta() {
      boolean diaCorrecto, mesCorrecto, anioCorrecto;
      anioCorrecto = anio > 0;
      mesCorrecto = mes >= 1 && mes <= 12;
      switch (mes) {
          case 2:
              if (esBisiesto()) {
                  diaCorrecto = dia >= 1 && dia <= 29;
              } else {
                  diaCorrecto = dia >= 1 && dia <= 28;
              }
              break;
          case 4:
          case 6:
          case 9:
          case 11:
              diaCorrecto = dia >= 1 && dia <= 30;
              break;
          default:
              diaCorrecto = dia >= 1 && dia <= 31;
      }
      return diaCorrecto && mesCorrecto && anioCorrecto;
  }

  //Método privado para comprobar si el anio es bisiesto
  //Este método lo utiliza el método fechaCorrecta
  private boolean esBisiesto() {
      return (anio % 4 == 0 && anio % 100 != 0 || anio % 400 == 0);
  }

  //Método que modifica la fecha cambiándola por la del día siguiente                                           
  public void diaSiguiente() {
      dia++;
      if (!fechaCorrecta()) {
          dia = 1;
          mes++;
          if (!fechaCorrecta()) {
              mes = 1;
              anio++;
          }

      }
  }
}