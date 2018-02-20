/*
 * Nazwa:Kalkulator
 *
 * Opis:Program ten to graficzny kalkulator wykonujacy podstawowe czynnosci arytmetyczne.Dzieki zastosowaniu GUI jest przyjazny dla
 *		kazdego uzytkownika.
 *
 *
 * Kompilacja:javac Kalkulator.java
 * Uruchomienie: java Kalkulator
 */

import javax.swing.*;       //zaimportowanie potrzebnych bibliotek
import java.awt.event.*;

//utowrzenie klasy Kalkulator wraz z implementacja interfejsu zmiany stanu komponentu
class Kalkulator implements ActionListener
{
	//utworzenie potrzebnych pol klasy
	JButton[] przycisk= new JButton[17];		
    JFrame f;								
    JTextField poleTekstu;
   	
    static double m=0, n=0, wynik=0;
    static int operator=0;
    public String nazwy="+-/*.=";

    public Kalkulator()
    {
        //utowrzenie okna glownego oraz przyciskow
        f=new JFrame("Kalkulator GUI");
        poleTekstu=new JTextField();		//utworzenie pola tekstowego
        poleTekstu.setEditable(false);		//zablokowanie mozliwosci jego edycji
		poleTekstu.setHorizontalAlignment(SwingConstants.RIGHT);
		
		int j=0;
		for(int i=0;i<17;i++){
			przycisk[i]=new JButton(""+i);		//utowrzenie przyciskow od 0 do 9
			if(i>=11){
				przycisk[i]=new JButton(nazwy.substring(j,j+1));	//dzieki zastosowaniu substring nie trzeba recznie w kodzie wprowadzac znakow typu '+' '*'
				j++;
			}		
		}
		

     //Rozmieszczenie w oknie poszczegolnych klawiszy oraz ustalenie wielkosci

         poleTekstu.setBounds(30,40,280,32);
         przycisk[7].setBounds(40,100,52,42);
         przycisk[8].setBounds(110,100,52,42);
         przycisk[9].setBounds(180,100,52,42);
         przycisk[13].setBounds(250,100,52,42);

         przycisk[4].setBounds(40,170,52,42);
         przycisk[5].setBounds(110,170,52,42);
         przycisk[6].setBounds(180,170,52,42);
         przycisk[14].setBounds(250,170,50,42);

         przycisk[1].setBounds(40,240,52,42);
         przycisk[2].setBounds(110,240,52,42);
         przycisk[3].setBounds(180,240,52,42);
         przycisk[12].setBounds(250,240,52,42);
         
         przycisk[0].setBounds(40,310,52,42);
         przycisk[15].setBounds(110,310,52,42);
         przycisk[16].setBounds(180,310,52,42);
         przycisk[11].setBounds(250,310,52,42);
        

        //dodanie poszczegolnych elementow graficznych do okna
        for( int i=0;i<17;i++){
        	f.add(przycisk[i]);
        }
        f.add(poleTekstu);
      
        //ustawienie widocznosci oraz dodanie podstawowych funkcji okna
        f.setLayout(null);
        f.setVisible(true);
        f.setSize(350,450);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//dodanie wydarzen
		for(int i=0;i<17;i++){
			przycisk[i].addActionListener(this);
		}
		 

    }

    //pobieranie danych z poszczegolnych klawiszy przy pomocy petli if
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==przycisk[1])
            poleTekstu.setText(poleTekstu.getText().concat("1"));

        if(e.getSource()== przycisk[2])
            poleTekstu.setText(poleTekstu.getText().concat("2"));

        if(e.getSource()== przycisk[3])
            poleTekstu.setText(poleTekstu.getText().concat("3"));

        if(e.getSource()== przycisk[4])
            poleTekstu.setText(poleTekstu.getText().concat("4"));

        if(e.getSource()== przycisk[5])
            poleTekstu.setText(poleTekstu.getText().concat("5"));

        if(e.getSource()== przycisk[6])
            poleTekstu.setText(poleTekstu.getText().concat("6"));

        if(e.getSource()== przycisk[7])
            poleTekstu.setText(poleTekstu.getText().concat("7"));

        if(e.getSource()== przycisk[8])
            poleTekstu.setText(poleTekstu.getText().concat("8"));

        if(e.getSource()== przycisk[9])
            poleTekstu.setText(poleTekstu.getText().concat("9"));

        if(e.getSource()== przycisk[15])
            poleTekstu.setText(poleTekstu.getText().concat("."));

        if(e.getSource()== przycisk[0])
            poleTekstu.setText(poleTekstu.getText().concat("0"));

        if(e.getSource()== przycisk[11])
        {
            m =Double.parseDouble(poleTekstu.getText());
            operator=1;                              //dodatkowo w przyciskach operatorow utworzono operatory ktore posluza pozniej w petli switch
            poleTekstu.setText("");
        }

        if(e.getSource()== przycisk[12])
        {
            m =Double.parseDouble(poleTekstu.getText());
            operator=2;
            poleTekstu.setText("");
        }

        if(e.getSource()== przycisk[14])
        {
            m =Double.parseDouble(poleTekstu.getText());
            operator=3;
            poleTekstu.setText("");
        }

        if(e.getSource()== przycisk[13])
        {
            m =Double.parseDouble(poleTekstu.getText());
            operator=4;
            poleTekstu.setText("");
        }

        if(e.getSource()== przycisk[16])
        {
             n =Double.parseDouble(poleTekstu.getText());
                                                    //Jesli zostanie wybrana ktoras z operacji typu mnoz,dziel
                                                    //zostanie wykonana jedna z instrukcji switch
             switch(operator)
             {
                 case 1: wynik = m + n;
                    break;

                 case 2: wynik= m - n;
                    break;

                 case 3: wynik = m * n;
                    break;

                 case 4: wynik = m / n;
                    break;

                 default: wynik =0;
             }

             poleTekstu.setText(""+ wynik);
        }


    }

    public static void main(String...s)
    {
        new Kalkulator();
    }
}