/*
	Singel Script for compiling via Command Line
*/
import java.util.Scanner;
import java.util.Random;

class MemorySimulator extends Thread
{

    static byte LangIndex = 0;
    static byte SimulatorMode = 0;
    static byte AlgIndex=0;
    static int Proc;
    static int ProcMem[];
    static int MemBlock=1;
    static int MemBlockSize[];
    static int LifeTime[];
    static int SleepTime;
    static Scanner scan = new Scanner(System.in);
    static int i,j;
    static int SubMenu=0;
    static int lastMemBlock;
    static byte temp=0;
    
    static Random rand;

    public static void main(String[] args) 
    {
        LanguageMenu();
    }
 
    public static void LanguageMenu() 
    {
        //Choosing Program Language
        System.out.println(Language.LangResources[LangIndex][0]+Language.LangResources[LangIndex][20]);
        System.out.print(Language.LangResources[LangIndex][17]);
        LangIndex = scan.nextByte();
        LangIndex-=1;
        if (LangIndex==0 || LangIndex==1)
        {
            clr();
            temp=LangIndex;
            MainMenu();
        }
        else if (LangIndex==2)
        {
            clr();
            LangIndex=temp;
            System.out.println(Language.LangResources[LangIndex][18]);
            System.exit(0);
        }
        else
        {
            LangIndex=temp;
            System.out.println(Language.LangResources[LangIndex][19]);
            LanguageMenu();
        }
        
    }

    public static void MainMenu() 
    {
        do
        {
            System.out.println("\n\t" + Language.LangResources[LangIndex][0]+Language.LangResources[LangIndex][1]);
            System.out.print(Language.LangResources[LangIndex][2]+"\n\t"+Language.LangResources[LangIndex][3]);
            SimulatorMode=scan.nextByte();
            if (SimulatorMode==1)
            {
                do
                {
                    clr();
                    System.out.print("\n\t"+Language.LangResources[LangIndex][4]+"\n\t"+Language.LangResources[LangIndex][6]+"\n\t"+Language.LangResources[LangIndex][5]+"\n\t"+Language.LangResources[LangIndex][3]);
                    AlgIndex=scan.nextByte();
                    
                    if (AlgIndex==1)
                    {
                        clr();
                        AutoModeProcess("FirstFit");
                        break;
                    }
                    else if (AlgIndex==2)
                    {
                        clr();
                        AutoModeProcess("BestFit");
                        break;
                        
                    }
                    else if (AlgIndex==3)
                    {
                        clr();
                        AutoModeProcess("WorstFit");
                        break;
                    }
                    else if (AlgIndex==4)
                    {
                        clr();
                        AutoModeProcess("NextFit");
                        break;
                        
                    }
                    else if (AlgIndex==5)
                    {
                        clr();
                        AutoModeProcess("BuddySystem");
                        break;
                        
                    }
                    else if (AlgIndex==6)
                    {
                        clr();
                        MainMenu();
                        break;
                    }
                    else if (AlgIndex==7)
                    {
                        
                        clr();
                        System.out.println(Language.LangResources[LangIndex][21]);
                        System.exit(0);
                        break;
                    }
                    else
                    {
                        System.out.println("\n\t"+Language.LangResources[LangIndex][7]);
                    }
                            
                }
                while(AlgIndex<1 || AlgIndex>7);
                break;
            }
            else if (SimulatorMode==2)
            {
                do
                {
                    clr();
                    System.out.print("\n\t"+Language.LangResources[LangIndex][13]+"\n\t"+Language.LangResources[LangIndex][5]+"\n\t"+Language.LangResources[LangIndex][3]);
                    AlgIndex=scan.nextByte();
                    if (AlgIndex==1)
                    {
                        clr();
                        ManualModeProcess("FirstFit");
                        break;
                    }
                    else if (AlgIndex==2)
                    {
                        clr();
                        ManualModeProcess("BestFit");
                        break;               
                    }
                    else if (AlgIndex==3)
                    {
                        clr();
                        ManualModeProcess("WorstFit");
                        break;
                    }
                    else if (AlgIndex==4)
                    {
                        clr();
                        ManualModeProcess("NextFit");
                        break;
                    }
                    else if (AlgIndex==5)
                    {
                        clr();
                        ManualModeProcess("BuddySystem");
                        break;
                        
                    }
                    else if (AlgIndex==6)
                    {
                        clr();
                        MainMenu();
                        break;
                    }
                    else if (AlgIndex==7)
                    {
                        clr();
                        System.out.println(Language.LangResources[LangIndex][21]);
                        System.exit(0);
                        break;
                    }
                    else
                    {
                        System.out.println("\n\t"+Language.LangResources[LangIndex][7]);
                    }            
                
                }while(AlgIndex<1 || AlgIndex>7);
                break;
            }
            else if (SimulatorMode==3)
            {
                System.out.println(Language.LangResources[LangIndex][22]);
                String[][] Authors=
                {
                    {
                        Language.LangResources[LangIndex][23],
                        Language.LangResources[LangIndex][24],
                        Language.LangResources[LangIndex][25],
                        Language.LangResources[LangIndex][25],
                        Language.LangResources[LangIndex][25],
                        "[Universitas Ibn Khaldun Bogor]",
                        "[Copyright 2015]"
                    },
                    {
                        "Riyan Saputra Irawan\t(141105151104)",
                        "Zainal Mubarok\t\t(141105151167)",
                        "M.Naufal Fahmi\t\t(141105150720)",
                        "Ghamal Nasser\t\t(141105150809)",
                        "Abdul EriSusanto\t\t(141205151454)"
                    }
                };
                for(i=0;i<5;i++)
                { 
                    System.out.print("\n\t" + Authors[0][i]);
                    try 
                    {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) 
                    {
                        return;
                    }
                    System.out.print("\n\t" + Authors[1][i]);
                }
                
                    System.out.print("\n\t" + Authors[0][5]);
                    System.out.print("\n\t\t" + Authors[0][6]+"\n\n");
                    
                MainMenu();
                break;
            }
            else if (SimulatorMode==4)
            {
                clr();
                LanguageMenu();
                break;
            }
            else if (SimulatorMode==5)
            {
                clr();
                System.out.println(Language.LangResources[LangIndex][30]);
                System.exit(0);
                break;
            }
            else
            {
                System.out.println("\n\t"+Language.LangResources[LangIndex][7]);
            }
        }
        while (SimulatorMode<1 || SimulatorMode>5);
    } 
    
    public static void AutoModeProcess(String Alg) 
    {
        rand = new Random();
        int MaxProcess=25;
        int MaxBlockMem=4;
        int MaxLifeTime=2000;
        int MaxSleepTime=500;
        
        if (Alg.equals("FirstFit"))
        {
            System.out.println("\n\t"+Language.LangResources[LangIndex][04]+"\n\t"+Language.LangResources[LangIndex][8]);
        } 
        if (Alg.equals("BestFit"))
        {
            System.out.println("\n\t"+Language.LangResources[LangIndex][04]+"\n\t"+Language.LangResources[LangIndex][9]);
        } 
        if (Alg.equals("WorstFit"))
        {
            System.out.println("\n\t"+Language.LangResources[LangIndex][04]+"\n\t"+Language.LangResources[LangIndex][10]);
        } 
        if (Alg.equals("NextFit"))
        {
            System.out.println("\n\t"+Language.LangResources[LangIndex][04]+"\n\t"+Language.LangResources[LangIndex][11]);
        } 
        if (Alg.equals("BuddySystem"))
        {
            System.out.println("\n\t"+Language.LangResources[LangIndex][04]+"\n\t"+Language.LangResources[LangIndex][12]);
        }
        
        if (Alg.equals("BuddySystem"))
        {
            MemoryAlgorithms.BuddySystem();
            MainMenu();
        }
        else
        {
            /*
             This Statements to Generate Processes and Memory
             Max Proceesses is 25 Process
             Max Memory Block is 4 Blocks
             Total Amount Memory Block is 1MB
             */
            System.out.println("\n\t" + Language.LangResources[LangIndex][16]);
            System.out.println(Language.LangResources[LangIndex][26]);

            //Generate MaxProccess
            do {
                Proc = rand.nextInt(MaxProcess);
            } while (Proc <= 0);
            ProcMem = new int[Proc];
            LifeTime = new int[Proc];

            //Generate MemoryBlocksSize
            i = 0;
            MemBlock = 4;
            MemBlockSize = new int[MemBlock];
            do {
                do {
                    MemBlockSize[i] = rand.nextInt(1024);
                } while (MemBlockSize[i] <= 0);
                i += 1;
                if (i == 4) {
                    if ((MemBlockSize[0] + MemBlockSize[1] + MemBlockSize[2] + MemBlockSize[3]) == 1024) {
                        i = 4;
                    } else {
                        i = 0;
                    }
                }
            } while (i != 4);

            //Proccess Memory Blocks Needed
            for (i = 0; i < Proc; i++) {
                ProcMem[i] = rand.nextInt(4);
                switch (ProcMem[i]) {
                    case 0: {
                        ProcMem[i] = 10;
                        break;
                    }
                    case 1: {
                        ProcMem[i] = 20;
                        break;
                    }
                    case 2: {
                        ProcMem[i] = 40;
                        break;
                    }
                    case 3: {
                        ProcMem[i] = 60;
                        break;
                    }
                    default: {
                        ProcMem[i] = 60;
                        break;
                    }
                }
                System.out.println(Language.LangResources[LangIndex][27] + (i + 1) + " :" + ProcMem[i] + " KB");
                //Generate LifeTime Process
                LifeTime[i] = rand.nextInt(MaxLifeTime);

            }
            for (i = 0; i < MemBlock; i++) {
                System.out.println(Language.LangResources[LangIndex][28] + (i + 1) + " : " + MemBlockSize[i] + " KB");
            }
            /*
             END OF GENERATING...
             */
            //Processes 
            MemoryAlgorithms.Proc = Proc;
            MemoryAlgorithms.ProcMem = ProcMem;
            MemoryAlgorithms.MemBlock = MemBlock;
            MemoryAlgorithms.MemBlockSize = MemBlockSize;
            MemoryAlgorithms.LifeTime = LifeTime;
            MemoryAlgorithms.LangIndex = LangIndex;
            if (Alg.equals("FirstFit")) {
                MemoryAlgorithms.FirstFit();
            }
            if (Alg.equals("BestFit")) {
                MemoryAlgorithms.BestFit();
            }
            if (Alg.equals("WorstFit")) {
                MemoryAlgorithms.WorstFit();
            }
            if (Alg.equals("NextFit")) {
                do {
                    lastMemBlock = rand.nextInt(MemBlock);
                } while (lastMemBlock < 0 || lastMemBlock >= (MemBlock - 1));
                MemoryAlgorithms.lastMemBlock = (lastMemBlock + 1);

                MemoryAlgorithms.NextFit();
            }

            do {
                System.out.print(Language.LangResources[LangIndex][29]);
                SubMenu = scan.nextInt();
                if (SubMenu == 1) {
                    clr();
                    AutoModeProcess(Alg);
                    break;
                } else if (SubMenu == 2) {
                    clr();
                    MainMenu();
                    break;
                } else if (SubMenu == 3) {
                    clr();
                    System.out.println(Language.LangResources[LangIndex][30]);
                    System.exit(0);
                    break;
                } else {
                    System.out.println("\n\t" + Language.LangResources[LangIndex][7]);
                }

            } while (SubMenu < 1 || SubMenu > 3);

        }
        
    }
    
    public static void ManualModeProcess(String Alg)
    {
        
        if (Alg.equals("FirstFit"))
        {
            System.out.println("\n\t"+Language.LangResources[LangIndex][13]+"\n\t"+Language.LangResources[LangIndex][8]);
        }
        if(Alg.equals("BestFit"))
        {
            System.out.println("\n\t"+Language.LangResources[LangIndex][13]+"\n\t"+Language.LangResources[LangIndex][9]);
        }
        if (Alg.equals("WorstFit"))
        {
            System.out.println("\n\t"+Language.LangResources[LangIndex][13]+"\n\t"+Language.LangResources[LangIndex][10]);
        }
        if(Alg.equals("NextFit"))
        {
            System.out.println("\n\t"+Language.LangResources[LangIndex][13]+"\n\t"+Language.LangResources[LangIndex][11]);
        }
        if(Alg.equals("BuddySystem"))
        {
            System.out.println("\n\t"+Language.LangResources[LangIndex][13]+"\n\t"+Language.LangResources[LangIndex][12]);
        }
        
        if(Alg.equals("BuddySystem"))
        {
            MemoryAlgorithms.BuddySystem();
            MainMenu();
        }
        else
        {
            System.out.print(Language.LangResources[LangIndex][31]);
            Proc = scan.nextInt();
            ProcMem = new int[Proc];
            LifeTime = new int[Proc];
            System.out.println(Language.LangResources[LangIndex][32]);
            for (i = 0; i < Proc; i++) {
                System.out.print(Language.LangResources[LangIndex][33] + (i + 1) + Language.LangResources[LangIndex][34] + Proc + " :");
                ProcMem[i] = scan.nextInt();
                System.out.print(Language.LangResources[LangIndex][35] + (i + 1) + Language.LangResources[LangIndex][34] + Proc + " :");
                LifeTime[i] = scan.nextInt();
            }
            System.out.print(Language.LangResources[LangIndex][36]);
            MemBlock = scan.nextInt();
            MemBlockSize = new int[MemBlock];
            System.out.print(Language.LangResources[LangIndex][37]);
            for (i = 0; i < MemBlock; i++) {
                System.out.print(Language.LangResources[LangIndex][38] + (i + 1) + Language.LangResources[LangIndex][34] + MemBlock + " :");
                MemBlockSize[i] = scan.nextInt();
            }

            MemoryAlgorithms.Proc = Proc;
            MemoryAlgorithms.ProcMem = ProcMem;
            MemoryAlgorithms.MemBlock = MemBlock;
            MemoryAlgorithms.MemBlockSize = MemBlockSize;
            MemoryAlgorithms.LifeTime = LifeTime;
            MemoryAlgorithms.LangIndex = LangIndex;
            if (Alg.equals("FirstFit")) {
                MemoryAlgorithms.FirstFit();

            } else if (Alg.equals("BestFit")) {
                MemoryAlgorithms.BestFit();

            } else if (Alg.equals("WorstFit")) {
                MemoryAlgorithms.WorstFit();

            } else if (Alg.equals("NextFit")) 
            {
                do 
                {
                    System.out.print(Language.LangResources[LangIndex][69]);
                    lastMemBlock = scan.nextInt();
                    
                } while (lastMemBlock < 0 || lastMemBlock >= MemBlock );
                
                MemoryAlgorithms.lastMemBlock = lastMemBlock;
                MemoryAlgorithms.NextFit();

            }

            do {
                System.out.print(Language.LangResources[LangIndex][39]);
                SubMenu = scan.nextInt();
                if (SubMenu == 1) {
                    clr();
                    ManualModeProcess(Alg);
                    break;
                } else if (SubMenu == 2) {
                    clr();
                    MainMenu();
                    break;
                } else if (SubMenu == 3) {
                    clr();
                    System.out.println(Language.LangResources[LangIndex][30]);
                    System.exit(0);
                    break;
                } else {
                    System.out.println("\n\t" + Language.LangResources[LangIndex][7]);
                }

            } while (SubMenu < 1 || SubMenu > 3);
        }
        
        
    }
      
    public static void clr()
    {
        for (i=0;i<7;i++)
        {
            System.out.println();
        }
    }
}

class MemoryAlgorithms extends Thread
{
    static int i,j;
    static boolean memFull=false;
    static int MinMemory,MemIndex=0,MaxMemory;
    static int[] sortindex;
    static int[] tempstat,tempstatmem,tempstatproc;
    static int tempx;
    static int[] sortlt,templt;
    static int lastMemBlock;
    static int LangIndex=MemorySimulator.LangIndex;
    
    //Important Atr
    
    static int Proc;
    static int[] ProcMem;
    static int MemBlock;
    static int[] MemBlockSize;
    static int[] LifeTime;
    
    //main algorithm
    
    public static void FirstFit()
    {
        
        tempstat=new int[MemBlock];
        sortlt=new int[Proc];
        templt=new int[Proc];
        tempstatproc=new int[Proc];
        
        System.out.print(Language.LangResources[LangIndex][40]);
        
        for (j = 0; j < MemBlock; j++) 
        {
            tempstat[j] = MemBlockSize[j];
        }
        for (j = 0; j < Proc; j++) 
        {
            templt[j] = LifeTime[j];
        }

        
        //Added Process to Memory
        System.out.print(Language.LangResources[LangIndex][41]);
        for (i=0;i<Proc;i++)
        {
            System.out.print(Language.LangResources[LangIndex][42]+(i+1)+Language.LangResources[LangIndex][43]+ProcMem[i]+" KB");
            for (j=0;j<MemBlock;j++)
            {
                if (ProcMem[i]<=MemBlockSize[j])
                {
                    MemBlockSize[j]-=ProcMem[i];
                    tempstatproc[i]=j;
                    System.out.println(Language.LangResources[LangIndex][44]+(j+1));
                    memFull=false;
                    break;
                }
                else
                {
                    if (j==(MemBlock-1))
                    {
                        System.out.println(Language.LangResources[LangIndex][45]);
                        memFull=true;
                    }
                }
                
            }
            if (memFull == false) 
            {
                System.out.print(Language.LangResources[LangIndex][46]);
                for (j = 0; j < MemBlock; j++) 
                {
                    System.out.print(Language.LangResources[LangIndex][47]+ (j + 1) + Language.LangResources[LangIndex][48] + tempstat[j]+" KB");
                    if (tempstat[j]==MemBlockSize[j])
                    {
                        System.out.print(Language.LangResources[LangIndex][49]);
                    }
                    else
                    {
                        System.out.print(Language.LangResources[LangIndex][50]+ MemBlockSize[j] + " KB");
                    }
                    System.out.print(Language.LangResources[LangIndex][46]);
                }
                System.out.print(Language.LangResources[LangIndex][51] + LifeTime[i] + Language.LangResources[LangIndex][52]);
                System.out.print(Language.LangResources[LangIndex][53]);
                
            }
            else
            {
                System.out.println(Language.LangResources[LangIndex][54]);
                break;
            }
            
        }
        Proc=i;
        Finishing();
        
        
    }
    
    public static void BestFit()
    { 
        tempstat=new int[MemBlock];
        tempstatmem=new int[MemBlock];
        sortindex=new int[MemBlock];
        sortlt=new int[Proc];
        templt=new int[Proc];
        tempstatproc=new int[Proc];
        
        
        System.out.print(Language.LangResources[LangIndex][55]);
        
        for (i = 0; i < MemBlock; i++) {
            tempstatmem[i] = MemBlockSize[i];
        }
        for (i = 0; i < MemBlock; i++) 
        {
            tempstat[i] = MemBlockSize[i];
        }
        
        for (j = 0; j < Proc; j++) 
        {
            templt[j] = LifeTime[j];
        }
        
        //Finding Available Minimum Memory...
        for (i = 0; i < MemBlock; i++) 
        {
            for (j=i;j<MemBlock;j++)
            {
                if (tempstat[j]<=tempstat[i])
                {
                    tempx=tempstat[j];
                    tempstat[j]=tempstat[i];
                    tempstat[i]=tempx;
                }
            }
        }
        for (i = 0; i < MemBlock; i++) 
        {
            j=0;
            do
            {
                if(tempstat[i]==MemBlockSize[j])
                {
                    sortindex[i]=j;
                    break;
                }
                else
                {
                    j+=1;
                }
            }while(j<MemBlock);
        }
        
        System.out.print(Language.LangResources[LangIndex][41]);
        for (i=0;i<Proc;i++)
        {
            System.out.print(Language.LangResources[LangIndex][42]+ (i + 1) + Language.LangResources[LangIndex][43] + ProcMem[i] + " KB");
           
            
            j=0;
            do
            {
                if (ProcMem[i] <= MemBlockSize[sortindex[j]]) 
                {
                    MemBlockSize[sortindex[j]] -= ProcMem[i];
                    System.out.println(Language.LangResources[LangIndex][44]+(sortindex[j]+1));
                    tempstatproc[i]=sortindex[j];
                    memFull = false;
                    break;
                }
                else
                {
                    j+=1;
                }
                
            }while(j<(MemBlock));
            if(j>=MemBlock)
            {        
                memFull=true;
            }
            
            if (memFull == false) 
            {

                System.out.print(Language.LangResources[LangIndex][46]);
                for (j = 0; j < MemBlock; j++) 
                {
                    System.out.print(Language.LangResources[LangIndex][47]+ (j + 1) + Language.LangResources[LangIndex][48] + tempstatmem[j] + " KB");
                    if (tempstatmem[j] == MemBlockSize[j]) 
                    {
                        System.out.print(Language.LangResources[LangIndex][49]);
                    }else 
                    {
                        System.out.print(Language.LangResources[LangIndex][50] + MemBlockSize[j] + " KB");
                    }
                    System.out.print(Language.LangResources[LangIndex][46]);
                }
                
                System.out.print(Language.LangResources[LangIndex][51] + LifeTime[i] + Language.LangResources[LangIndex][52]);
                System.out.print(Language.LangResources[LangIndex][53]);
            } else 
            {
                System.out.println(Language.LangResources[LangIndex][54]);
                break;

            }
        }
        
        Proc=i;
        Finishing();
        

    }
    
    public static void WorstFit()
    {
        tempstat=new int[MemBlock];
        tempstatmem=new int[MemBlock];
        sortindex=new int[MemBlock];
        sortlt=new int[Proc];
        templt=new int[Proc];
        tempstatproc=new int[Proc];
        
        
        System.out.print(Language.LangResources[LangIndex][56]);
        
        for (i = 0; i < MemBlock; i++) {
            tempstatmem[i] = MemBlockSize[i];
        }
        for (i = 0; i < MemBlock; i++) 
        {
            tempstat[i] = MemBlockSize[i];
        }
        
        for (j = 0; j < Proc; j++) 
        {
            templt[j] = LifeTime[j];
        }
        
        //Finding Available Minimum Memory...
        for (i = 0; i < MemBlock; i++) 
        {
            for (j=i;j<MemBlock;j++)
            {
                if (tempstat[j]>=tempstat[i])
                {
                    tempx=tempstat[j];
                    tempstat[j]=tempstat[i];
                    tempstat[i]=tempx;
                }
            }
        }
        for (i = 0; i < MemBlock; i++) 
        {
            j=0;
            do
            {
                if(tempstat[i]==MemBlockSize[j])
                {
                    sortindex[i]=j;
                    break;
                }
                else
                {
                    j+=1;
                }
            }while(j<MemBlock);
        }
        
        System.out.print(Language.LangResources[LangIndex][41]);
        for (i=0;i<Proc;i++)
        {
            System.out.print(Language.LangResources[LangIndex][42] + (i + 1) + Language.LangResources[LangIndex][43] + ProcMem[i] + " KB");
           
            
            j=0;
            do
            {
                if (ProcMem[i] <= MemBlockSize[sortindex[j]]) 
                {
                    MemBlockSize[sortindex[j]] -= ProcMem[i];
                    System.out.println(Language.LangResources[LangIndex][44]+(sortindex[j]+1));
                    tempstatproc[i]=sortindex[j];
                    memFull = false;
                    break;
                }
                else
                {
                    j+=1;
                }
                
            }while(j<(MemBlock));
            if(j>=MemBlock)
            {        
                memFull=true;
            }
            
            if (memFull == false) 
            {

                System.out.print(Language.LangResources[LangIndex][46]);
                for (j = 0; j < MemBlock; j++) 
                {
                    System.out.print(Language.LangResources[LangIndex][47] + (j + 1) + Language.LangResources[LangIndex][48] + tempstatmem[j] + " KB");
                    if (tempstatmem[j] == MemBlockSize[j]) 
                    {
                        System.out.print(Language.LangResources[LangIndex][49]);
                    }else 
                    {
                        System.out.print(Language.LangResources[LangIndex][50] + MemBlockSize[j] + " KB");
                    }
                    System.out.print(Language.LangResources[LangIndex][46]);
                }
                
                System.out.print(Language.LangResources[LangIndex][51] + LifeTime[i] + Language.LangResources[LangIndex][52]);
                System.out.print(Language.LangResources[LangIndex][53]);
            } else 
            {
                System.out.println(Language.LangResources[LangIndex][54]);
                break;

            }
        }
        
        Proc=i;
        Finishing();
        
    }
    
    public static void NextFit()
    {
        tempstat=new int[MemBlock];
        sortlt=new int[Proc];
        templt=new int[Proc];
        tempstatproc=new int[Proc];
        
        System.out.print(Language.LangResources[LangIndex][57]+lastMemBlock);
        
        for (j = 0; j < MemBlock; j++) 
        {
            tempstat[j] = MemBlockSize[j];
        }
        for (j = 0; j < Proc; j++) 
        {
            templt[j] = LifeTime[j];
        }

        //Added Process to Memory
        System.out.print(Language.LangResources[LangIndex][41]);
        for (i=0;i<Proc;i++)
        {
            System.out.print(Language.LangResources[LangIndex][42]+(i+1)+Language.LangResources[LangIndex][43]+ProcMem[i]+" KB");
            for (j=lastMemBlock;j<MemBlock;j++)
            {
                if (ProcMem[i]<=MemBlockSize[j])
                {
                    MemBlockSize[j]-=ProcMem[i];
                    tempstatproc[i]=j;
                    System.out.println(Language.LangResources[LangIndex][44]+(j+1));
                    memFull=false;
                    break;
                }
                else
                {
                    if (j==(MemBlock-1))
                    {
                        System.out.println(Language.LangResources[LangIndex][45]);
                        memFull=true;
                    }
                }
                
            }
            if (memFull == false) 
            {
                System.out.print(Language.LangResources[LangIndex][46]);
                for (j = 0; j < MemBlock; j++) 
                {
                    System.out.print(Language.LangResources[LangIndex][47] + (j + 1) + Language.LangResources[LangIndex][48] + tempstat[j]+" KB");
                    if (tempstat[j]==MemBlockSize[j])
                    {
                        System.out.print(Language.LangResources[LangIndex][49]);
                    }
                    else
                    {
                        System.out.print(Language.LangResources[LangIndex][50]+ MemBlockSize[j] + " KB");
                    }
                    System.out.print(Language.LangResources[LangIndex][46]);
                }
                System.out.print(Language.LangResources[LangIndex][51]+ LifeTime[i] + Language.LangResources[LangIndex][52]);
                System.out.print(Language.LangResources[LangIndex][53]);
                
            }
            else
            {
                System.out.println(Language.LangResources[LangIndex][54]);
                break;
            }
            
        }
        Proc=i;
        Finishing();
        
    }

    public static void BuddySystem()
    {
        System.out.println(Language.LangResources[LangIndex][70]);
    }
    
    //Additional Fuction to Algorithm
    public static void Finishing()
    {
        //Finishing Process
        System.out.print(Language.LangResources[LangIndex][58]);
        
            for (i = 0; i < Proc; i++) 
            {
                for (j=i;j<Proc;j++)
                {
                    if (LifeTime[j]<=LifeTime[i])
                    {
                        tempx=LifeTime[j];
                        LifeTime[j]=LifeTime[i];
                        LifeTime[i]=tempx;
                    }
                }
            }
            
            for (i = 0; i < Proc; i++) 
            {
                j=0;
                do
                {
                    if(LifeTime[i]==templt[j])
                    {
                        sortlt[i]=j;
                        break;
                    }
                    else
                    {
                        j+=1;
                    }
                }while(j<Proc);
            }
            
            for (i=0;i<Proc;i++)
            {
                try 
                {
                    Thread.sleep(LifeTime[i]);
                    System.out.print(Language.LangResources[LangIndex][59]+(sortlt[i]+1)+Language.LangResources[LangIndex][60]+LifeTime[i]+Language.LangResources[LangIndex][52]);
                    tempx=MemBlockSize[tempstatproc[sortlt[i]]];
                    MemBlockSize[tempstatproc[sortlt[i]]]+=ProcMem[sortlt[i]];
                    System.out.print(Language.LangResources[LangIndex][61]+(tempstatproc[sortlt[i]]+1)+Language.LangResources[LangIndex][62]+tempx+Language.LangResources[LangIndex][63]+MemBlockSize[tempstatproc[sortlt[i]]]+" KB");
                   
                } catch (InterruptedException e) 
                {
                    return;
                }
                
                System.out.print(Language.LangResources[LangIndex][64]);
            }
            
            
            System.out.print(Language.LangResources[LangIndex][65]);
            for (i=0;i<MemBlock;i++)
            {
                System.out.print(Language.LangResources[LangIndex][66]+(i+1)+Language.LangResources[LangIndex][67]+MemBlockSize[i]+" KB"+Language.LangResources[LangIndex][68]);
            }
    }
}

class Language 
{
    public static final String[][] LangResources=
    {
        {
        	//English
        	"\n\t[ Welcome To Memory Simulator Program ]",//00
            "\n\t            [ Main Menu ]", //01
            "\n\t1> Run Simulator with Required Settings(Automatic)\n\t2> Run Simulator with Manual Settings\n\t3> About Program\n\t4> Change Language\n\t5> Exit Program", //02
            "\n\tChoose Your Decision : ", //03
            "\n\t[ Memory Simulator Auto Mode ]", //04
            "\n\t\n\t1> First Fit Algorithm\n\t2> Best Fit Algorithm\n\t3> Worst Fit Algorithm\n\t4> Next Fit Algorithm\n\t5> Buddy System Algorithm\n\t6> Main Menu\n\t7> Exit Program", //05
            "\n\tThis Mode will automatically generate any processes with itself by random memory blocks between 10KB,20KB,40KB,or 60KB"+
            "\n\tAnd Total Amount System Memory is 1MB @1KB/block,each Proccess will have it's time process on blocks memory"+
            "\n\tYou can choose which algorithm do you wanna use and give you statistic"+
            "", //06
            "\n\tSorry Your Input Didn't Valid ! , Try Again.", //07
            "[ First Fit Algorithm ]", //08
            "[ Best Fit Algorithm ]", //09
            "[ Worst Fit Algorithm ]", //10
            "[ Next Fit Algorithm ]", //11
            "[ Buddy System Algorithm ]", //12
            "\n\t[ Memory Simulator Manual Mode ]", //13
            "\n\tThis Mode will require a user input setting for many processe and each memory blocks needed.And require for many memory blocks and each memory size in KB"+
            "\n\tNo Limit for processes and memory blocks.You can choose which algorithm do you wanna use and give you statistic"+
            "", //14
            "Press Enter to Back to Menu...", //15
            "[ Process Started ]", //16
            "\t1>English\n\t2>Indonesian\n\t3>Exit Program\n\tEnter Your Decision Here : ",//17
            "\n\t[ Thanks For Use This Program :) ]",//18
            "\n\tYour Input Didn't Valid ! Try Again.",//19
            "\n\t        [ Choose Your Language ]\n", //20
            "\n\t[ Thanks For Use This Program :) ]",//21
            "\n\t[ Program Credits ]",//22
            "[Program Desainer & Writer]",//23
            "[Translator]",//24
            "[Support]",//25
            "\n\t[ Added Processes And Memory Blocks ]",//26
            "\t> Memory Size of Process ",//27
            "\t> Size of Memory Block ",//28
            "\n\tProcess Done...\n\n\t1> Repeat This Algorithm\n\t2> To Main Menu\n\t3> Exit Program\n\t"+
            		"Input your choice here : ",//29
            "\n\t[ Thanks For Use This Program :) ]",//30
            "\n\t[ Setting Processes ]\n\t> How Many Process Do You Want ? : ",//31
            "\n\t[ Processes Memory Size & Time ]",//32
            "\t> Memory Size(KB) Process ",//33
            " of ",//34
            "\t> Memory Time(ms) Process ", //35
            "\n\t[ Setting Memory ]\n\t> How Many Memory Blocks Do You Want ? : ",//36
            "\n\t[ Memory Blocks Size ]\n",//37
            "\t> Memory Size(KB) for Block ",//38
            "\n\tProcess Done...\n\n\t1> Repeat This Algorithm\n\t2> To Main Menu\n\t3> Exit Program\n\t",//39
            //======================
            "\n\t[ Statistic Result using First Fit ]\n\n",//40
            "\n\n\t|==============================================|"+
            "\n\t| Allocating Processes Memory to Memory Blocks |"+
            "\n\t|==============================================|",//41
            "\n\tNo.Process\t\t\t\t: ",//42
            "\n\tProcess Memory\t\t\t\t: ",//43
            "\n\tAllocated To Memory Blocks No\t\t: ",//44
            "\n\tAllocated To Memory Blocks No\t\t: Null",//45
            "\n\t---------------------------------------------------",//46
            "\n\tNo.Memory Blocks\t\t\t: ",//47
            "\n\tMemory Block Size\t\t\t: ",//48
            "\n\t[ Memory Block Not Allocated Yet ]",//49
            "\n\tMemory Block Size After Allocated\t: " ,//50
            "\n\tTime Process\t\t\t\t: ",//51
            " miliseconds",//52
            "\n\t****************************************************************",//53
            "\n\tOut Of Memory !...\n\tContinue with Process that successfull allcocated to Memory Blocks",//54
            "\n\t[ Statistic Result using Best Fit ]\n\n",//55
            "\n\t[ Statistic Result using Worst Fit ]\n\n",//56
            "\n\t[ Statistic Result using Next Fit ]\n\t>Last Memory Block Used : ",//57
            "\n\n\t|=================================================|"+
            "\n\t| Finishing Processes And Releasing Memory Blocks |"+
            "\n\t|=================================================|",//58
            "\n\t>Finishing Process No ",//59
            " in ",//60
            "\n\t[ Memory Releasing ]\n\t>Memory Block No\t: ",//61
            "\n\t>Current Size\t\t: ",//62
            " KB\n\t>After Releasing\t: ",//63
            "\n\t-------------------------------------------------------------------",//64
            "\n\n\t[ Current Memory Status ]",//65
            "\n\t>No.Memory Blocks\t: ",//66
            "\n\tSize Memory Block\t: ",//67
            "\n\t--------------------------------------",//68
            "\n\tWhere Lastest Posisiion of Memory Blocks\t: ",//69
            "\n\n\n\t We're Sorry :(\n\tBecause of LIMITEDNESS of our java Programming Language Knowledge and Work Time\n\tBuddy System is Available on C Programing Only\n\tWe've enclose .C file with this java files \n\tYou Can Compile and Try it\n\tThanks for your Understanding...\n\n\n"//70
        },
        
        {
        	//Indonesia
        	"\n\t[ Selamat Datang di Program Simulator Memori ]",//00
            "\n\t                [ Menu Utama ]", //01
            "\n\t1> Jalankan Simulator Dengan Pengaturan Otomatis \n\t2> Jalankan Simulator Dengan Pengaturan Manual\n\t3> Tentang Program\n\t4> Ubah Bahasa\n\t5> Keluar Program", //02
            "\n\tMasukan Pilihan : ", //03
            "\n\t[ Simulator Memori Mode Otomatis ]", //04
            "\n\t\n\t1> Algoritma First Fit\n\t2> Algoritma Best Fit\n\t3> Algoritma Worst Fit\n\t4> Algoritma Next Fit\n\t5> Algoritma Buddy System\n\t6> Menu Utama\n\t7> Keluar Program", //05
            "\n\tMode ini akan otomatis menghasilkan banyak prosesnya sendiri dengan blok memori secara acak antara 10KB, 20KB, atau 60KB"
            +"\n\tdan jumlah sistem memori sebesar 1MB @1KB/blok, setiap proses akan memiliki waktu proses terhadap blok memori."
            +"\n\tAtau anda bisa memilih \"SEMUA ALGORITMA\" dan memberikan statistiknya satu persatu ", //06
            "\n\tMaaf data yang anda masukkan tidak benar ! Coba lagi.", //07
            "[ Algoritma First Fit ]", //08
            "[ Algoritma Best Fit ]", //09
            "[ Algoritma Worst Fit ]", //10
            "[ Algoritma Next Fit ]", //11
            "[ Algoritma Buddy System ]", //12
            "\n\t[ Simulasi Mode Memori Manual ]", //13
            "\n\tMode ini membutuhkan masukan anda untuk proses yang banyak dan setiap blok memori yang dibutuhkan. Dan membutuhkan blok memori dan setiap ukuran memori dalam besaran KB."
            +"\n\tTidak ada batas untuk proses dan blok memorinya. Anda bisa memilih algoritma mana yang akan digunakan dan memberi statiskinya.", //14
            "Tekan Enter untuk kembali ke Menu...", //15
            "[ Proses Dimulai ]", //16
            "\t1>Bahasa Inggris\n\t2>Bahasa Indonesia\n\t3>Keluar Program\n\tMasukkan Pilihanmu kesini : ",//17
            "\n\t[ Terima Kasih Telah Menggunakan Program Ini :) ]",//18
            "\n\tMasukkan anda tidak valid! Coba lagi.",//19
            "\n\t           [ Pilih Bahasa Anda ]\n", //20
            "\n\t[ Terima Kasih Telah Menggunakan Program Ini :) ]",//21
            "\n\t[ Penghargaan Program ]",//22
            "[Penulis & Desain Program]",//23
            "[Alihbahasa]",//24
            "[Pendukung]",//25
            "\n\t\n\tMenambahkan Proses dan Blok Memori ]",//26
            "\t> Proses Ukuran Memori ",//27
            "\t> Ukuran Blok Memori ",//28
            "\n\tProses Seselai...\n\n\t1> Mengulang Algoritma ini\n\t2> Ke Menu Utama\n\t3> Keluar Program\n\t"+
            		"Masukan pilihan anda disini :",//29
            "\n\t[ Terima Kasih Telah Menggunakan Program Ini :) ]",//30
            "\n\t[ Pengaturan Proses ]\n\t> Berapa Proses yang anda inginkan ? : ",//31
            "\n\t[ Proses Ukuran Memory & Waktu ]",//32
            "\t> Ukuran Memori(KB) Proses ",//33
            " dari ",//34
            "\t> Waktu Memori(ms)  Proses ", //35
            "\n\t[ Pengaturan Memori ]\n\t> Berapa banyak Blok Memori yang anda inginkan ? : ",//36
            "\n\t[ Ukuran Blok Memori ]\n",//37
            "\t> Ukuran Memori(KB) untuk Block ",//38
            "\n\tProses Selesai...\n\n\t1> Mengulang Algoritma ini\n\t2> Ke Menu Utama\n\t3> Keluar Program\n\t",//39==29
            //======================
            "\n\t[ Hasil Statistik Penggunaan First Fit ]\n\n",//40
            "\n\n\t|======================================|"+
            "\n\t| Proses Alokasi Memori ke Blok Memori |"+
            "\n\t|======================================|",//41
            "\n\tNo.Proses\t\t\t\t: ",//42
            "\n\tProses Memory\t\t\t\t: ",//43
            "\n\tAlokasi ke Blok Memori ke\t\t: ",//44
            "\n\tAlokasi ke Blok Memori ke\t\t: Null",//45
            "\n\t---------------------------------------------------",//46
            "\n\tNo.Blok Memori\t\t\t\t: ",//47
            "\n\tUkuran Blok Memori\t\t\t: ",//48
            "\n\t[ Blok Memori Belum Dialokasikan ]",//49
            "\n\tBlok Memori Setelah Dialokasikan\t: " ,//50
            "\n\tWaktu Proses\t\t\t\t: ",//51
            " milidetik",//52
            "\n\t****************************************************************",//53
            "\n\tDiluar Memori !...\n\tMelanjutkan dengan proses proses yang berhasil ke Blok Memori",//54
            "\n\t[ Hasil Statistik Penggunaan Best Fit ]\n\n",//55
            "\n\t[ Hasil Statistik Penggunaan Worst Fit ]\n\n",//56
            "\n\t[ Hasil Statistik Penggunaan Next Fit ]\n\t>Last Memory Block Used : ",//57
            "\n\n\t|===============================================|"+
            "\n\t| Penyelesaian Proses dan Pelepasan Blok Memori |"+
            "\n\t|===============================================|",//58
            "\n\t>Penyelesaian Proses No ",//59
            " dalam ",//60
            "\n\t[ Pelepasan Memori ]\n\t>Blok Memori No\t\t: ",//61
            "\n\t>Ukuran Sekarang\t: ",//62
            " KB\n\t>Setelah Pelepasan\t: ",//63
            "\n\t-------------------------------------------------------------------",//64
            "\n\n\t[ Status Memori Sekarang ]",//65
            "\n\t>No.Blok Memori\t\t: ",//66
            "\n\tUkuran Blok Memori\t: ",//67
            "\n\t--------------------------------------",//68
            "\n\tDimana Posisi Terakhir Blok Memori\t: ",//69
            "\n\n\n\t Kami Mohon Maaf :(\n\tKarena Keterbatasan Pengetahuan kami tentang Bahasa Pemerograman java dan Waktu Pengerjaan\n\tBuddy System Hanya Tersedia dalam versi Bahasa Program C\n\tKami Telah Melampirkan file .C bersama file java ini \n\tAnda Dapat MengKompilasi dan Jalankan itu\n\tTerima Kasih Untuk Pengertiannya...\n\n\n"//70
        
        }
    };
}

