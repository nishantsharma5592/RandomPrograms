/*
	Author: Nishant Sharma
 	Email: <nishantsharma5592@gmail.com>
 */


/*

	I asked my students (during my APC tenure at VIT Vellore [No longer active!]) to print the following 2D 5x5 pattern.

	_ _ * _ _

	_ * _ * _

	* _ _ _ *

	_ * _ * _

	_ _ * _ _



	After some thinking, this is the code that I came up with to print this pattern.

*/

/*
public class Pattern{

    public static void main(String args[]){

            int mid = 2;

            for (int index=0; index<5; index++){

                    for (int subindex=0; subindex<5; subindex++){

                        if (index<=mid){

                                if(index+subindex == 2 || (subindex-index==2)){

                                    System.out.print("*");

                                }

                                else{

                                    System.out.print("_");

                                }

                        }

                        else{

                            if(index-subindex == 2|| index+subindex==6){

                                System.out.print("*");

                            }

                            else{

                                System.out.print("_");

                            }

                        }

                    }   

                    System.out.println();

          } 

    }

}  

*/


/*
	I could then extend it to a more general code from 5x5 to nxn for an odd n.

*/

public class Pattern{

    int n;

    Pattern(int user_in){

            n=user_in;

    }

    // For an nxn pattern with n being odd

    void display(){

        int mid = (n-1)/2;

            for (int index=0; index<n; index++){

                    for (int subindex=0; subindex<n; subindex++){

                        if (index<=mid){

                                if(index+subindex == mid || (subindex-index==mid)){

                                    System.out.print("*");

                                }

                                else{

                                    System.out.print("_");

                                }

                        }

                        else{

                            if(index-subindex == mid|| index+subindex==(n+mid-1)){

                                System.out.print("*");

                            }

                            else{

                                System.out.print("_");

                            }

                        }

                    }

                    System.out.println();

            }

    }



    public static void main(String args[]){

        Pattern obj = new Pattern(25);

        obj.display();

    }

}   
