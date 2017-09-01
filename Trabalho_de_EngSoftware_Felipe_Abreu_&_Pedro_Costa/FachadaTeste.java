public class FachadaTeste{
   private static FachadaTeste fachadaSingleton = null;
   // repare no construtor privado, somente métodos dessa classe pode utiliza-lo &#40;no caso getInstance&#40;&#41;
   private FachadaTeste(){
      //algum código aqui
    }
   // retorna a única instancia
   public static FachadaTeste getInstance(){
      if (fachadaSingleton == null) {
         fachadaSingleton = new FachadaTeste();
        }
        
     return fachadaSingleton;
    }
    //métodos da fachada
   public void algumMetodoDaFachada(){
      //algum codigo aqui
   }
   public void algumMetodoDaFachada2(){
      //algum codigo aqui
    }
}