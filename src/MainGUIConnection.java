class Controller implements ActionListener {

     private Model model;

     private View view;

 

     public Controller() {

          view = new View(this);

          model = new Model();

     }

   

     /**

      * Instantiates itself to get its own constructor going.

      */

     public static void main(String args[]) {

          Controller ctr = new Controller();

     }

           

     public void actionPerformed (ActionEvent evt) {

       view.show(model.beep());

     }

}