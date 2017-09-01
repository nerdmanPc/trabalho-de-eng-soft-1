public class Biblioteca {
   private static Biblioteca fachadaSingleton = null;
   // repare no construtor privado, somente métodos dessa classe pode utiliza-lo &#40;no caso getInstance&#40;&#41;
   private Biblioteca() {
      //algum código aqui
    }   
   // retorna a única instancia
   public static Biblioteca getInstance() {
      if (fachadaSingleton == null) {
         fachadaSingleton = new Biblioteca();
        }
     return fachadaSingleton;
    }
    //métodos da fachada
   public void algumMetodoDaFachada1(){
      //algum codigo aqui
    }
   public void algumMetodoDaFachada2(){
      //algum codigo aqui
    }
}