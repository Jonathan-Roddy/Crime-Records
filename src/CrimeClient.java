import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import Crime.Crime;
import Crime.CrimeDb;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import static java.util.Comparator.comparing;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author Jonathan Roddy
 */

public class CrimeClient {
    
    private static ObjectInputStream objInStream;
    public static List<Crime> CrimeList;
    public int totalPerType = 0;
    public static HashMap<String, Integer> data = new HashMap<String, Integer>();
    public static Scanner scannerSub = new Scanner(System.in);   
    
    // Declare file writer streams
    public static FileWriter fileWriterStreamForClintInteration = null;
    public static FileWriter fileWriterStreamForCrimeRecord = null;
    // Declare a print stream
    public static PrintWriter outClient = null;
    public static PrintWriter outCrime = null;
    
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
    
        CrimeDb.doConnection();
        
        Scanner scanner = new Scanner(System.in); 
        
        
        try
        {
            // Create file input and output streams
            fileWriterStreamForClintInteration = new FileWriter("ClintesInteractions.txt");
            fileWriterStreamForCrimeRecord = new FileWriter("CrimeRecord.txt");
            
            // Create a stream tokenizer wrapping file stream
            outClient = new PrintWriter(fileWriterStreamForClintInteration);
            outCrime = new PrintWriter(fileWriterStreamForCrimeRecord);
            
            // Create a socket to connect to the server
            Socket connectToServer = new Socket("localhost", 8000);


            // Create an output stream to the server
            objInStream = new ObjectInputStream(connectToServer.getInputStream());
            
            // Create an output stream to send data to the server
            DataOutputStream osToServer =  new DataOutputStream(connectToServer.getOutputStream());

            //recieve crimeList from server
            List<Crime> crimeList = (List<Crime>)objInStream.readObject();
            // Save crimelist in text file
            for(Crime aCrime : crimeList )
                outCrime.println(aCrime.toString());
            // Clone the crimeList 
            CrimeList = new ArrayList<Crime>(crimeList); 
            
            while(true)
            {
                boolean quit = false;
                do
                {
                    // Display menu to client
                    displayMenu();
                    // Write to client file
                    outClient.println("Client is now looking at the Menu");
                                        
                    System.out.print("Choose menu item: ");
                    int input = scanner.nextInt();
                    // Write to client file
                    outClient.println("Client has chosen :" + input );

                    switch (input) {
                        case 1:
                            // send to server your choice of input
                            osToServer.writeInt(input);
                            osToServer.flush();

                            System.out.println("\nPrint all Crimes");

                            // Print everything in the list
                            for(Crime aCrime : crimeList )
                                System.out.println(aCrime.toString());
                            // Write to client file
                            outClient.println("Client has Printed all crimes ");
                            break;

                        case 2:
                            // send to server your choice of input
                            osToServer.writeInt(input);
                            osToServer.flush();

                            System.out.println("\nDisplaying highest rate of Crimes");

                            // Convert to steam
                            Crime c =  (Crime) crimeList.stream()                                       
                            //.filter(x -> "CAVAN/MONAGHAN".equals(x.getGardaDivision() ) )
                            //.filter(.min(Comparator.comparing(Cr/*i*/me::total)) )
                            .findAny()                                                          
                            .orElse(null);
                            System.out.println(c);
                            // Write to client file
                            outClient.println("Client has Printed highest rate of crimes ");
                            break;

                        case 3:
                            // send to server your choice of input
                            osToServer.writeInt(input);
                            osToServer.flush();
                            
                            System.out.println("\nTotals per Type: in Ascending order ");
                            System.out.println("");
                            getTotalCrimesPerOffenceType();
                            // Write to client file
                            outClient.println("Client has Printed Crimes by offence type ");
                            break;

                        case 4:
                            // send to server your choice of input
                            osToServer.writeInt(input);
                            osToServer.flush();
                                
                            // display all regions
                            displayRegions();
                            // Write to client file
                            outClient.println("Client has asked for Regions sub  menu ");
                            break;
                            
                        case 5:
                            // send to server your choice of input
                            osToServer.writeInt(input);
                            osToServer.flush();
                            
                            System.out.println("\nTotals per Year ");
                            System.out.println("");
                            getTotalCrimesPerYear();
                            // Write to client file
                            outClient.println("Client has printed totals per year ");
                            break;

                        case 6:
                            // send to server your choice of input
                            osToServer.writeInt(input);
                            osToServer.flush();
                            getOccurence();
                            // Write to client file
                            outClient.println("Client has printed offence and occurence");
                                                        
                            break;
                        case 7:
                            // send to server your choice of input
                            osToServer.writeInt(input);
                            osToServer.flush();
                           
                            System.out.println("\nTotals per the last quarter from each year ");
                            
                            List<Crime> maxList = new ArrayList<Crime>();
                            
                            // Convert to steam
                            Crime m1 =  (Crime) CrimeList.stream().max(comparing((name) -> name.getQ42003() ) ).get();
                            maxList.add(m1);
                            Crime m2 =  (Crime) CrimeList.stream().max(comparing((name) -> name.getQ42004() ) ).get();
                            maxList.add(m2);
                            Crime m3 =  (Crime) CrimeList.stream().max(comparing((name) -> name.getQ42005() ) ).get();
                            maxList.add(m3);
                            Crime m4 =  (Crime) CrimeList.stream().max(comparing((name) -> name.getQ42006() ) ).get();
                            maxList.add(m4);
                            Crime m5 =  (Crime) CrimeList.stream().max(comparing((name) -> name.getQ42007() ) ).get();
                            maxList.add(m5);
                            Crime m6 =  (Crime) CrimeList.stream().max(comparing((name) -> name.getQ42008() ) ).get();
                            maxList.add(m6);
                            Crime m7 =  (Crime) CrimeList.stream().max(comparing((name) -> name.getQ42009() ) ).get();
                            maxList.add(m1);
                            Crime m8 =  (Crime) CrimeList.stream().max(comparing((name) -> name.getQ42010() ) ).get();
                            maxList.add(m8);
                            Crime m9 =  (Crime) CrimeList.stream().max(comparing((name) -> name.getQ42011() ) ).get();
                            maxList.add(m9);
                            Crime m10 =  (Crime) CrimeList.stream().max(comparing((name) -> name.getQ42012() ) ).get();
                            maxList.add(m10);
                            Crime m11 =  (Crime) CrimeList.stream().max(comparing((name) -> name.getQ42013() ) ).get();
                            maxList.add(m11);
                            Crime m12 =  (Crime) CrimeList.stream().max(comparing((name) -> name.getQ42015() ) ).get();
                            maxList.add(m12);
                            Crime m13 =  (Crime) CrimeList.stream().max(comparing((name) -> name.getQ42016() ) ).get();
                            maxList.add(m13);
                            Crime m14 =  (Crime) CrimeList.stream().max(comparing((name) -> name.getQ42017() ) ).get();
                            maxList.add(m14);
                            Crime m15 =  (Crime) CrimeList.stream().max(comparing((name) -> name.getQ42018() ) ).get();
                            maxList.add(m15);
                            
                            System.out.println("2003 -> " + m1.getTypeOfOffence() + m1.getOffence());
                            System.out.println("2003 -> " + m2.getTypeOfOffence() + m2.getOffence());
                            System.out.println("2003 -> " + m3.getTypeOfOffence() + m3.getOffence());
                            System.out.println("2003 -> " + m4.getTypeOfOffence() + m4.getOffence());
                            System.out.println("2003 -> " + m5.getTypeOfOffence() + m5.getOffence());
                            System.out.println("2003 -> " + m6.getTypeOfOffence() + m6.getOffence());
                            System.out.println("2003 -> " + m7.getTypeOfOffence() + m7.getOffence());
                            System.out.println("2003 -> " + m8.getTypeOfOffence() + m8.getOffence());
                            System.out.println("2003 -> " + m9.getTypeOfOffence() + m9.getOffence());
                            System.out.println("2003 -> " + m10.getTypeOfOffence() + m10.getOffence());
                            System.out.println("2003 -> " + m11.getTypeOfOffence() + m11.getOffence());
                            System.out.println("2003 -> " + m12.getTypeOfOffence() + m12.getOffence());
                            System.out.println("2003 -> " + m13.getTypeOfOffence() + m13.getOffence());
                            System.out.println("2003 -> " + m14.getTypeOfOffence() + m14.getOffence());
                            System.out.println("2003 -> " + m15.getTypeOfOffence() + m15.getOffence());
                            
                            System.out.println("\nFrom the data gathered, The likely hood of : "+mostCommon(maxList).getOffence() + " will happen");
                            
                            //System.out.println(CrimeList.stream().max(comparing((name) -> name.getQ42018())).get());
        
                            // Write to client file
                            outClient.println("Client has printed what could be happen on 2019 Q4");
                                                        
                            break;

                        case 0:
                        
                        System.out.println("Closing this connection : Goodbye");
                        // Write to client file
                        outClient.println("Client is leaving the main menu ");
                        quit = true;
                        return; 
                        
                        default:
                            System.out.println("Wrong number, Please try again...");
                        break;
                        
                    } 
                } while (!quit);

                // Close off everything
                scanner.close();
                scannerSub.close(); 
                objInStream.close();
                osToServer.close();
                connectToServer.close();

            }

        }
        catch (IOException ex)
        {
          System.err.println(ex);
        }
        finally   {
            try     
            {
                if (fileWriterStreamForClintInteration != null) fileWriterStreamForClintInteration.close();
            }
            catch (IOException ex)  
            {
                System.out.println(ex);
            }
        }
    }  
   
    private static void displayMenu()
    {
        System.out.println("");
        System.out.println("");
        System.out.println("**********************************************");
        System.out.println(" Please Enter Your option below     ");
        System.out.println(" Type '0' to exit the application ");
        System.out.println("**********************************************");
        System.out.println(" 1 -> Display all Records  ");
        System.out.println(" 2 -> Display Highest Record + 2nd ");
        System.out.println(" 3 -> Display Total Crimes Per Offence Type  ");
        System.out.println(" 4 -> Display Most crimes per a region ");
        System.out.println(" 5 -> Display Total crimes per Year");
        System.out.println(" 6 -> Display Occurence of crime  ");
        System.out.println(" 7 -> What is likely to happen in 2009 Q4 ");
        System.out.println("**********************************************");
  }
    
    private static void displayRegions()
    {   
        boolean quit = false;
        do
        {
            System.out.println("");
            System.out.println("**********************************************");
            System.out.println(" 1 -> Northern Region  ");
            System.out.println(" 2 -> Western Region ");
            System.out.println(" 3 -> Southern Region  ");
            System.out.println(" 4 -> Eastern Region");
            System.out.println(" 5 -> South Eastern Region  ");
            System.out.println(" 6 -> Dublin Metropoltian Region ");
            System.out.println("**********************************************");
            System.out.println(" Please Enter the number for the region below ");
            System.out.println(" Type '0' to exit this Menu ");
            
            // Write to client file
            outClient.println("Client is now looking at the Region sub menu");
            int subInput = scannerSub.nextInt();
            // Write to client file
            outClient.println("\tClient has chosen :" + subInput  + " in Region sub menu");
            
            String region = "";
            switch (subInput) {
                case 1:
                    // Northern Region 
                    region = "NORTHERN REGION";
                    for(Crime aCrime : CrimeList )
                    {
                        if(aCrime.getRegion().equals(region))
                        {
                            System.out.println(aCrime.getGardaDivision() + " --- " + aCrime.getTypeOfOffence() + " --- " +  aCrime.getTypeOfOffence() );
                        }
                    }
                    
                    break;

                case 2:
                    // Western Region
                    region = "WESTERN REGION";
                    for(Crime aCrime : CrimeList )
                    {
                        if(aCrime.getRegion().equals(region))
                        {
                            System.out.println(aCrime.getGardaDivision() + " --- " + aCrime.getTypeOfOffence() + " --- " +  aCrime.getTypeOfOffence() );;
                        }
                    }
                    break;

                case 3:
                    // Southern Region
                    region = "SOUTHERN REGION";
                    for(Crime aCrime : CrimeList )
                    {
                        if(aCrime.getRegion().equals(region))
                        {
                            System.out.println(aCrime.getGardaDivision() + " --- " + aCrime.getTypeOfOffence() + " --- " +  aCrime.getTypeOfOffence() );
                        }
                    }
                    break;

                case 4:
                    // Eastern Region
                    region = "EASTERN REGION";
                    for(Crime aCrime : CrimeList )
                    {
                        if(aCrime.getRegion().equals(region))
                        {
                            System.out.println(aCrime.getGardaDivision() + " --- " + aCrime.getTypeOfOffence() + " --- " +  aCrime.getTypeOfOffence() );
                        }
                    }
                    break;

                case 5:
                    // South Eastern Region 
                    region = "SOUTH EASTERN REGION";
                    for(Crime aCrime : CrimeList )
                    {
                        if(aCrime.getRegion().equals(region))
                        {
                            System.out.println(aCrime.getGardaDivision() + " --- " + aCrime.getTypeOfOffence() + " --- " +  aCrime.getTypeOfOffence() );
                        }
                    }
                    break;
                case 6:
                    // Dublin Metropoltian Region
                    region = "DUBLIN METROPOLITAN REGION";
                    for(Crime aCrime : CrimeList )
                    {
                        if(aCrime.getRegion().equals(region))
                        {
                            System.out.println(aCrime.getGardaDivision() + " --- " + aCrime.getTypeOfOffence() + " --- " +  aCrime.getTypeOfOffence() );
                        }
                    }
                    break;
                                    
                case 0:
                    quit = true;
                    System.out.println("Going back to Main Menu..");
                    // Write to client file
                    outClient.println("Client is leaving the sub menu ");
                    break;  
                } 
        } while (!quit);
        
    }
    
    private static void getTotalCrimesPerOffenceType()
    {
        int totalHomicideOffences = 0;
        int totalSexualOffences = 0;
        int totalAttemptMurder = 0;
        int totalDangerous = 0;
        int totalKidnapping = 0;
        int totalRobbery= 0;
        int totalBurglary= 0;
        int totalTheft= 0;
        int totalFraud= 0;
        int totalControlled= 0;
        int totalWeapons= 0;
        int totalDamage= 0;
        int totalPublic= 0;
        int totalOffencesGovernment= 0;
        int FinalTotal = 0;
        
        final String one = "HOMICIDE OFFENCES";
        final String two = "SEXUAL OFFENCES";
        final String three = "ATTEMPTS/THREATS TO MURDER/ASSAULTS/ HARASSMENTS A...";
        final String four = "DANGEROUS OR NEGLIGENT ACTS";
        final String five = "KIDNAPPING AND RELATED OFFENCES";
        final String six = "ROBBERY/EXTORTION AND HIJACKING OFFENCES";
        final String seven = "BURGLARY AND RELATED OFFENCES";
        final String eight = "THEFT AND RELATED OFFENCES";
        final String nine = "FRAUD/DECEPTION AND RELATED OFFENCES";
        final String ten = "CONTROLLED DRUG OFFENCES";
        final String eleven = "WEAPONS AND EXPLOSIVES OFFENCES";
        final String twelve = "DAMAGE TO PROPERTY AND ENVIRONMENT";
        final String thirteen = "PUBLIC ORDER AND OTHER SOCIAL CODE OFFENCES";
        final String fourteen = "OFFENCES AGAINST GOVERNMENT/ JUSTICE PROCEDURES AN...";
        
        for(Crime aCrime : CrimeList )
        {
            String type = aCrime.getTypeOfOffence();
            switch(type)
            {
                case one:
                    totalHomicideOffences++;
                    FinalTotal++;
                    break;
                case two:
                    totalSexualOffences++;
                    FinalTotal++;
                    break;
                case three:
                    totalAttemptMurder++;
                    FinalTotal++;
                    break;
                case four:
                    totalDangerous++;
                    FinalTotal++;
                    break;
                case five:
                    totalKidnapping++;
                    FinalTotal++;
                    break;
                case six:
                    totalRobbery++;
                    FinalTotal++;
                    break;
                case seven:
                    totalBurglary++;
                    FinalTotal++;
                    break;
                case eight:
                    totalTheft++;
                    FinalTotal++;
                    break;
                case nine:
                    totalFraud++;
                    FinalTotal++;
                    break;
                case ten:
                    totalControlled++;
                    FinalTotal++;
                    break;
                case eleven:
                    totalWeapons++;
                    FinalTotal++;
                    break;
                case twelve:
                    totalDamage++;
                    FinalTotal++;
                    break;
                case thirteen:
                    totalPublic++;
                    FinalTotal++;
                    break;
                case fourteen:
                    totalOffencesGovernment++;
                    FinalTotal++;
                    break;
                    
            }
            
        };
        // adding all data in a HashMap so you can sort answer
        // saving string 'offence type', integer 'total' 
        data.put(one , totalHomicideOffences);
        data.put(two , totalSexualOffences);
        data.put(three , totalAttemptMurder);
        data.put(four , totalDangerous);
        data.put(five , totalKidnapping);
        data.put(six , totalRobbery);
        data.put(seven , totalBurglary);
        data.put(eight , totalTheft);
        data.put(nine , totalFraud);
        data.put(ten , totalControlled);
        data.put(eleven , totalWeapons);
        data.put(twelve , totalDamage);
        data.put(thirteen , totalPublic);
        data.put(fourteen , totalOffencesGovernment);
        
        Set<Entry<String, Integer>> entries = data.entrySet();
        
        // sorting HashMap
        TreeMap<String, Integer> sorted = new TreeMap<>(data);
        Set<Entry<String, Integer>> mappings = sorted.entrySet();
        
        // there is no direct way to sort HashMap by values 
        // using comparator and overiding tis compare function
        
        Comparator<Entry<String, Integer>> valueComparator = new Comparator<Entry<String,Integer>>() {
            
            @Override
            public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
                Integer v1 = e1.getValue();
                Integer v2 = e2.getValue();
                return v1.compareTo(v2);
            }
        };
        
        // Sort method needs a List from styoe set to type list
        List<Entry<String, Integer>> listOfEntries = new ArrayList<Entry<String, Integer>>(entries);
        
        // sorting HashMap by values using comparator
        Collections.sort(listOfEntries, valueComparator);
        
        LinkedHashMap<String, Integer> sortedByValue = new LinkedHashMap<String, Integer>(listOfEntries.size());
        
        // copying entries from List to Map
        for(Entry<String, Integer> entry : listOfEntries){
            sortedByValue.put(entry.getKey(), entry.getValue());
        }
        
        Set<Entry<String, Integer>> entrySetSortedByValue = sortedByValue.entrySet();
        
        for(Entry<String, Integer> mapping : entrySetSortedByValue){
            System.out.println(mapping.getKey() + " ==> " + mapping.getValue());
        }
        
        System.out.println("\nCrime Total = " + FinalTotal);
        
    }
  
    private static void getTotalCrimesPerYear()
    {
        int total2003= 0, total2003Q1= 0,total2003Q2= 0,total2003Q3= 0,total2003Q4 = 0;
        int total2004= 0, total2004Q1= 0,total2004Q2= 0,total2004Q3= 0,total2004Q4 = 0;
        int total2005= 0, total2005Q1= 0,total2005Q2= 0,total2005Q3= 0,total2005Q4 = 0;
        int total2006= 0, total2006Q1= 0,total2006Q2= 0,total2006Q3= 0,total2006Q4 = 0;
        int total2007= 0, total2007Q1= 0,total2007Q2= 0,total2007Q3= 0,total2007Q4 = 0;
        int total2008= 0, total2008Q1= 0,total2008Q2= 0,total2008Q3= 0,total2008Q4 = 0;
        int total2009= 0, total2009Q1= 0,total2009Q2= 0,total2009Q3= 0,total2009Q4 = 0;
        int total2010= 0, total2010Q1= 0,total2010Q2= 0,total2010Q3= 0,total2010Q4 = 0;
        int total2011= 0, total2011Q1= 0,total2011Q2= 0,total2011Q3= 0,total2011Q4 = 0;
        int total2012= 0, total2012Q1= 0,total2012Q2= 0,total2012Q3= 0,total2012Q4 = 0;
        int total2013= 0, total2013Q1= 0,total2013Q2= 0,total2013Q3= 0,total2013Q4 = 0;
        int total2014= 0, total2014Q1= 0,total2014Q2= 0,total2014Q3= 0,total2014Q4 = 0;
        int total2015= 0, total2015Q1= 0,total2015Q2= 0,total2015Q3= 0,total2015Q4 = 0;
        int total2016= 0, total2016Q1= 0,total2016Q2= 0,total2016Q3= 0,total2016Q4 = 0;
        int total2017= 0, total2017Q1= 0,total2017Q2= 0,total2017Q3= 0,total2017Q4 = 0;
        int total2018= 0, total2018Q1= 0,total2018Q2= 0,total2018Q3= 0,total2018Q4 = 0;
        int total2019= 0, total2019Q1= 0,total2019Q2= 0,total2019Q3 = 0;
        
        for(Crime aCrime : CrimeList )
        {
            total2003Q1 = aCrime.getQ12003();
            total2003Q2 = aCrime.getQ22003();
            total2003Q3 = aCrime.getQ32003();
            total2003Q4 = aCrime.getQ42003();
            total2003 = total2003Q1+ total2003Q2 + total2003Q3+total2003Q4;
            
            total2004Q1 = aCrime.getQ12004();
            total2004Q2 = aCrime.getQ22004();
            total2004Q3 = aCrime.getQ32004();
            total2004Q4 = aCrime.getQ42004();
            total2004 = total2004Q1+ total2004Q2 + total2004Q3+total2004Q4;
            
            total2005Q1 = aCrime.getQ12005();
            total2005Q2 = aCrime.getQ22005();
            total2005Q3 = aCrime.getQ32005();
            total2005Q4 = aCrime.getQ42005();
            total2005 = total2005Q1+ total2005Q2 + total2005Q3+total2005Q4;
            
            total2006Q1 = aCrime.getQ12006();
            total2006Q2 = aCrime.getQ22006();
            total2006Q3 = aCrime.getQ32006();
            total2006Q4 = aCrime.getQ42006();
            total2006 = total2006Q1+ total2006Q2 + total2006Q3+total2006Q4;
            
            total2007Q1 = aCrime.getQ12007();
            total2007Q2 = aCrime.getQ22007();
            total2007Q3 = aCrime.getQ32007();
            total2007Q4 = aCrime.getQ42007();
            total2007 = total2007Q1+ total2007Q2 + total2007Q3+total2007Q4;
            
            total2008Q1 = aCrime.getQ12008();
            total2008Q2 = aCrime.getQ22008();
            total2008Q3 = aCrime.getQ32008();
            total2008Q4 = aCrime.getQ42008();
            total2008 = total2008Q1+ total2008Q2 + total2008Q3+total2008Q4;
            
            total2009Q1 = aCrime.getQ12009();
            total2009Q2 = aCrime.getQ22009();
            total2009Q3 = aCrime.getQ32009();
            total2009Q4 = aCrime.getQ42009();
            total2009 = total2009Q1+ total2009Q2 + total2009Q3+total2009Q4;
            
            total2010Q1 = aCrime.getQ12010();
            total2010Q2 = aCrime.getQ22010();
            total2010Q3 = aCrime.getQ32010();
            total2010Q4 = aCrime.getQ42010();
            total2010 = total2010Q1+ total2010Q2 + total2010Q3+total2010Q4;
            
            total2011Q1 = aCrime.getQ12011();
            total2011Q2 = aCrime.getQ22011();
            total2011Q3 = aCrime.getQ32011();
            total2011Q4 = aCrime.getQ42011();
            total2011 = total2011Q1+ total2011Q2 + total2011Q3+total2011Q4;
            
            total2012Q1 = aCrime.getQ12012();
            total2012Q2 = aCrime.getQ22012();
            total2012Q3 = aCrime.getQ32012();
            total2012Q4 = aCrime.getQ42012();
            total2012 = total2012Q1+ total2012Q2 + total2012Q3+total2012Q4;
            
            total2013Q1 = aCrime.getQ12013();
            total2013Q2 = aCrime.getQ22013();
            total2013Q3 = aCrime.getQ32013();
            total2013Q4 = aCrime.getQ42013();
            total2013 = total2013Q1+ total2013Q2 + total2013Q3+total2013Q4;
            
            total2014Q1 = aCrime.getQ12014();
            total2014Q2 = aCrime.getQ22014();
            total2014Q3 = aCrime.getQ32014();
            total2014Q4 = aCrime.getQ42014();
            total2014 = total2014Q1+ total2014Q2 + total2014Q3+total2014Q4;
            
            total2015Q1 = aCrime.getQ12015();
            total2015Q2 = aCrime.getQ22015();
            total2015Q3 = aCrime.getQ32015();
            total2015Q4 = aCrime.getQ42015();
            total2015 = total2015Q1+ total2015Q2 + total2015Q3+total2015Q4;
            
            total2016Q1 = aCrime.getQ12016();
            total2016Q2 = aCrime.getQ22016();
            total2016Q3 = aCrime.getQ32016();
            total2016Q4 = aCrime.getQ42016();
            total2016 = total2016Q1+ total2016Q2 + total2016Q3+total2016Q4;
           
            total2017Q1 = aCrime.getQ12017();
            total2017Q2 = aCrime.getQ22017();
            total2017Q3 = aCrime.getQ32017();
            total2017Q4 = aCrime.getQ42017();
            total2017 = total2017Q1+ total2017Q2 + total2017Q3+total2017Q4;
            
            total2018Q1 = aCrime.getQ12018();
            total2018Q2 = aCrime.getQ22018();
            total2018Q3 = aCrime.getQ32018();
            total2018Q4 = aCrime.getQ42018();
            total2018 = total2018Q1+ total2018Q2 + total2018Q3+total2018Q4;
            
            total2019Q1 = aCrime.getQ12019();
            total2019Q2 = aCrime.getQ22019();
            total2019Q3 = aCrime.getQ32019();
            total2019 = total2019Q1+ total2019Q2 + total2019Q3;
    
        }
        System.out.println("");
        System.out.println("**********************************************");
        System.out.println(" 2003 -> Q1 : "+ total2003Q1 + " Q2 : " + total2003Q2 + " Q3 : " + total2003Q3+ " Q4 :" + total2003Q4 + " Total : " + total2003);
        System.out.println(" 2004 -> Q1 : "+ total2004Q1 + " Q2 : " + total2004Q2 + " Q3 : " + total2004Q3+ " Q4 :" + total2004Q4 + " Total : " + total2004);
        System.out.println(" 2005 -> Q1 : "+ total2005Q1 + " Q2 : " + total2005Q2 + " Q3 : " + total2005Q3+ " Q4 :" + total2005Q4 + " Total : " + total2005);
        System.out.println(" 2006 -> Q1 : "+ total2006Q1 + " Q2 : " + total2006Q2 + " Q3 : " + total2006Q3+ " Q4 :" + total2006Q4 + " Total : " + total2006);
        System.out.println(" 2007 -> Q1 : "+ total2007Q1 + " Q2 : " + total2007Q2 + " Q3 : " + total2007Q3+ " Q4 :" + total2007Q4 + " Total : " + total2007);
        System.out.println(" 2008 -> Q1 : "+ total2008Q1 + " Q2 : " + total2008Q2 + " Q3 : " + total2008Q3+ " Q4 :" + total2008Q4 + " Total : " + total2008);
        System.out.println(" 2009 -> Q1 : "+ total2009Q1 + " Q2 : " + total2009Q2 + " Q3 : " + total2009Q3+ " Q4 :" + total2009Q4 + " Total : " + total2009);
        System.out.println(" 2010 -> Q1 : "+ total2010Q1 + " Q2 : " + total2010Q2 + " Q3 : " + total2010Q3+ " Q4 :" + total2010Q4 + " Total : " + total2010);
        System.out.println(" 2011 -> Q1 : "+ total2011Q1 + " Q2 : " + total2011Q2 + " Q3 : " + total2011Q3+ " Q4 :" + total2011Q4 + " Total : " + total2011);
        System.out.println(" 2012 -> Q1 : "+ total2012Q1 + " Q2 : " + total2012Q2 + " Q3 : " + total2012Q3+ " Q4 :" + total2012Q4 + " Total : " + total2012);
        System.out.println(" 2013 -> Q1 : "+ total2013Q1 + " Q2 : " + total2013Q2 + " Q3 : " + total2013Q3+ " Q4 :" + total2013Q4 + " Total : " + total2013);
        System.out.println(" 2014 -> Q1 : "+ total2014Q1 + " Q2 : " + total2014Q2 + " Q3 : " + total2014Q3+ " Q4 :" + total2014Q4 + " Total : " + total2014);
        System.out.println(" 2015 -> Q1 : "+ total2015Q1 + " Q2 : " + total2015Q2 + " Q3 : " + total2015Q3+ " Q4 :" + total2015Q4 + " Total : " + total2015);
        System.out.println(" 2016 -> Q1 : "+ total2016Q1 + " Q2 : " + total2016Q2 + " Q3 : " + total2016Q3+ " Q4 :" + total2016Q4 + " Total : " + total2016);
        System.out.println(" 2017 -> Q1 : "+ total2017Q1 + " Q2 : " + total2017Q2 + " Q3 : " + total2017Q3+ " Q4 :" + total2017Q4 + " Total : " + total2017);
        System.out.println(" 2018 -> Q1 : "+ total2018Q1 + " Q2 : " + total2018Q2 + " Q3 : " + total2018Q3+ " Q4 :" + total2018Q4 + " Total : " + total2018);
        System.out.println(" 2019 -> Q1 : "+ total2019Q1 + " Q2 : " + total2019Q2 + " Q3 : " + total2019Q3+  " Total : " + total2019);
        System.out.println("**********************************************");
        
        
        
    }
    
    private static void getOccurence()
    {
        List<String> offenceList = new ArrayList<String>();
        
        for(Crime aCrime : CrimeList )
        {
            for(int i = 0; i < CrimeList.size(); i++)
            {
                // add to offence list only if it doesnt exist already
                if(!offenceList.contains(aCrime.getOffence()))
                    offenceList.add(aCrime.getOffence());
            }
        }
        // printing the list of offeces
        System.out.println("");
        System.out.println(" All Offences that has happened : " + offenceList.size());
        int count = 0;
        for(String o : offenceList)
        {
            getOccurence(o);
            System.out.println(o);
            
        }    
        
        
    }
   
    public static void getOccurence(String offence)
    {
       int counter = 0;
       for(Crime aCrime : CrimeList )
       {
            if(aCrime.getOffence().equals(offence))
                counter++; 
       }
       // Testing this SELECT * FROM `crime` WHERE `Offence` = "Arson" ORDER BY `Region`  ASC and all come back as 28
        System.out.print("Total : "+counter + " -- ");
    }
    
    public static <T> T mostCommon(List<T> list){
        Map<T, Integer> map = new HashMap<>();

        for (T t : list) {
            Integer val = map.get(t);
            map.put(t, val == null ? 1 : val + 1);
        }

        Entry<T, Integer> max = null;

        for (Entry<T, Integer> e : map.entrySet()) {
            if (max == null || e.getValue() > max.getValue())
                max = e;
        }

        return max.getKey();
    }
    
}


