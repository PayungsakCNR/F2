private void checkScore(){
    if(gc.getCurrentPlayer().getScore() >= 10){
      System.out.println("Now, " + gc.getCurrentPlayer().getName() +  " have "  + gc.getCurrentPlayer().getScore() + " score ,do you want to use bosster??");
      JDialog.setDefaultLookAndFeelDecorated(true);
      int response = JOptionPane.showConfirmDialog(null, "Do you want to use bosster??,decress your score 10 score", gc.getCurrentPlayer().getName() + " Booster Skill",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    
      if (response == JOptionPane.NO_OPTION) {
        System.out.println("No button clicked");
      } 
      else if (response == JOptionPane.YES_OPTION) {
        /* Use Score for boost 5 steps walk by PaOv6. */
        System.out.println("Yes button clicked");
        gc.getCurrentPlayer().decressScore();
        System.out.println("Now you [" + gc.getCurrentPlayer().getName() + "]" + " score = " + gc.getCurrentPlayer().getScore());
        System.out.println("And walke 5 steps");
        gc.getCurrentPlayer().walk(5);
        System.out.println("walke 5 steps done!!");

      } 
      else if (response == JOptionPane.CLOSED_OPTION) {
        System.out.println("JOptionPane closed");
      }
    }
  }