
import java.util.Scanner;

public class ManagementTechniques {
    public ManagementTechniques() {
    }

    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu() {
        System.out.println("~~~WELCOME TO THE MAIN MENU OF OS LAB MANUAL~~~\n");
        System.out.println("~~It underlies various algorithms and techniques regarding operating systems.\n");
        int choice = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("\n1. ~~FIXED MEMORY MANAGEMENT TECHNIQUE~~");
        System.out.println("2. ~~VARIABLE MEMORY MANAGEMENT TECHNIQUE~~");
        System.out.println("3. ~~WORST -FIT TECHNIQUE~~");
        System.out.println("4. ~~BEST-FIT TECHNIQUE~~");
        System.out.println("5. ~~FIRST-FIT TECHNIQUE~~\n");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("CPU SCHEDULING ALGORITHMS~~");
        System.out.println("6. ~~FIRST COME FIRST SERVE TECHNIQUE~~");
        System.out.println("7. ~~SHORTEST JOB NEXT TECHNIQUE~~");
        System.out.println("8. ~~ROUND ROBIN TECHNIQUE~~");
        System.out.println("9. ~~PRIORITY TECHNIQUE~~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("DEADLOCK MANAGEMENT ALGORITHMS~~");
        System.out.println("10. ~~BANKERS ALGORITHM~~");
        System.out.println("11. ~~FCFS TECHNIQUE~~");
        System.out.println("12. ~~SCAN TECHNIQUE~~");
        System.out.println("13. ~~C-SCAN TECHNIQUE~~");

        boolean number;
        do {
            System.out.println("Enter choice of implementation~~ ");
            if (input.hasNextInt()) {
                choice = input.nextInt();
                number = true;
            } else {
                System.out.println("Sorry,you cannot enter letters or fractions.");
                System.out.println("Enter whole numbers according to choice~~ ");
                number = false;
                input.next();
            }
        } while(!number);

        if (choice == 1) {
            fixed();
        }

        if (choice == 2) {
            variable();
        }

        if (choice == 3) {
            worstFit();
        }

        if (choice == 4) {
            bestFit();
        }

        if (choice == 5) {
            firstFit();
        }

        if (choice == 6) {
            firstComeFirstServe();
        }

        if (choice == 7) {
            shortJobNext();
        }

        if (choice == 8) {
            roundRobin();
        }

        if (choice == 9) {
            priority();
        }

        if (choice == 10) {
            bankersAlgorithm();
        }

        if (choice == 11) {
            fcFs();
        }

        if (choice == 12) {
            scan();
        }

        if (choice == 13) {
            cScan();
        }

    }

    public static void fixed() {
        int memSize = 0;
        int partition = 0;
        int totalIntFrag = 0;
        int[] numProcesses = new int[5];
        int i;
        int process = 0;
        int counter = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("~~WELCOME TO MULTIPROGRAMMING WITH FIXED TASKS~~\n");

        boolean number;
        do {
            System.out.println("Enter memory size available~~ ");
            if (input.hasNextInt()) {
                memSize = input.nextInt();
                number = true;
            } else {
                System.out.println("Sorry,you cannot enter letters or fractions.");
                System.out.println("Enter whole numbers only~~ ");
                number = false;
                input.next();
            }
        } while(!number);

        System.out.println("Enter the number of partition or block size (in bytes)");

        do {
            if (input.hasNextInt()) {
                partition = input.nextInt();
                number = true;
            } else {
                System.out.println("Sorry,you cannot enter letters or fractions.");
                System.out.println("Enter whole numbers only~~ ");
                number = false;
                input.next();
            }
        } while(!number);

        int partitionSize = memSize / partition;
        System.out.println("Each partition in memory is " + partitionSize);
        System.out.println("Enter the number of processes");
        int numProcess = input.nextInt();


        for(i = 0; i < numProcess; ++i) {
            ++counter;
            System.out.println("Enter the memory required for process " + counter);
            numProcesses[i] = input.nextInt();
        }

        System.out.println("\nNumber of partitions available in memory is " + partitionSize);
        System.out.println("\n PROCESS \t MEMORY REQUIRED \t ALLOCATED \t INTERNAL FRAGMENTATION");

        for(i = 0; i < numProcess && process < partitionSize; ++i) {
            System.out.println(" " + i + "\t\t\t\t" + numProcesses[i]);
            if (numProcesses[i] > partition) {
                System.out.println("\t\t\t\t\t\t\t\t\tNO\t\t\t\t\t---");
            } else {
                int p = partition - numProcesses[i];
                System.out.println("\t\t\t\t\t\t\t\t\tYES\t\t\t\t\t" + p);
                totalIntFrag = totalIntFrag + partition - numProcesses[i];
                ++process;
            }
        }

        if (i > partitionSize) {
            System.out.println("Memory is full, process incomplete.");
        }

        System.out.println("\nTotal Internal Fragmentation is " + totalIntFrag);
        int extFrag = memSize - partitionSize * partition;
        System.out.println("\nTotal External Fragmentation is " + extFrag);

        mainMenu();
    }

    public static void variable() {
        int memSize = 0;
        int i;
        int n = 0;
        int counter = 0;
        int[] memRequired = new int[5];
        char ch = 'y';
        Scanner input = new Scanner(System.in);
        System.out.println("Enter memory size available(in bytes)");

        boolean number;
        do {
            if (input.hasNextInt()) {
                memSize = input.nextInt();
                number = true;
            } else {
                System.out.println("Sorry,you cannot enter letters or fractions.");
                System.out.println("Enter whole numbers only~~ ");
                number = false;
                input.next();
            }
        } while(!number);

        int tempLoc = memSize;


        for(i = 0; ch == 'y'; ++n) {
            ++counter;
            System.out.println("Enter memory required for process " + counter + " (in bytes) :");
            memRequired[i] = input.nextInt();
            if (memRequired[i] <= tempLoc) {
                System.out.println("\n Memory allocated for process: " + counter);
                tempLoc -= memRequired[i];
            } else {
                System.out.println("\n Memory is Full.");
            }

            System.out.println("\n Do you wish to continue? (yes/no");
            ch = input.next().charAt(0);
            ++i;
        }

        System.out.println("\nTotal Memory Available ---" + memSize);
        System.out.println("\nPROCESS \t\t MEMORY ALLOCATED");

        for(i = 0; i < n; ++i) {
            System.out.println("\n" + i + "1\t\t\t\t\t" + memRequired[i]);
        }

        int totalMemory = memSize - tempLoc;
        System.out.println("\nTotal Memory Allocated is " + totalMemory);
        System.out.println("\nTotal external Fragment is " + tempLoc);
    }

    public static void worstFit() {
        int nb = 0;
        int nf = 0;
        int temp = 0;
        int max = 25;
        int[] frag = new int[max];
        int[] b = new int[max];
        int[] f = new int[max];
        int[] ff = new int[max];
        int[] bf = new int[max];
        Scanner input = new Scanner(System.in);
        System.out.println("--WORST-FIT TECHNIQUE---\n");

        boolean number;
        do {
            System.out.println("Enter the number of blocks");
            System.out.println("Enter the number of files");
            if (input.hasNextInt()) {
                nb = input.nextInt();
                nf = input.nextInt();
                number = true;
            } else {
                System.out.println("Sorry,you cannot enter letters or fractions.");
                System.out.println("Enter whole numbers only~~ ");
                number = false;
                input.next();
            }
        } while(!number);

        System.out.println("Enter the size of the blocks");

        int i;
        for(i = 1; i <= nb; ++i) {
            System.out.println("Block:" + i);
            b[i] = input.nextInt();
        }

        System.out.println("Enter the size of the files~~ ");

        for(i = 1; i <= nf; ++i) {
            System.out.println("File~~ " + i);
            f[i] = input.nextInt();
        }

        for(i = 1; i <= nf; ++i) {
            for(int j = 1; j <= nb; ++j) {
                if (bf[j] != 1) {
                    temp = b[j] - f[i];
                    if (temp >= 0) {
                        ff[i] = j;
                    }
                }
            }

            frag[i] = temp;
            bf[ff[i]] = 1;
        }

        System.out.println("\nFile_no\tFile_size\tBlock_no\tBlock_size\tFragment");

        for(i = 1; i <= nf; ++i) {
            System.out.println(i + "\t\t" + f[i] + "\t\t" + ff[i] + "\t\t" + b[ff[i]] + "\t\t" + frag[i]);
        }

    }

    public static void bestFit() {
        int lowest = 1000;
        int max = 25;
        int[] frag = new int[max];
        int[] b = new int[max];
        int[] f = new int[max];
        int[] bf = new int[max];
        int[] ff = new int[max];
        Scanner input = new Scanner(System.in);
        System.out.println("--Best-Fit Technique--\n");
        System.out.println("Enter the number of blocks");
        int nb = input.nextInt();
        System.out.println("Enter the number of files");
        int nf = input.nextInt();
        System.out.println("Enter the size of blocks");

        int i;
        for(i = 1; i < nb; ++i) {
            System.out.println("Block: " + i);
            b[i] = input.nextInt();
        }

        System.out.println("Enter the size of files");

        for(i = 1; i < nf; ++i) {
            System.out.println("File: " + i);
            f[i] = input.nextInt();
        }

        for(i = 1; i < nf; ++i) {
            for(int j = 1; j < nb; ++j) {
                if (bf[j] != 1) {
                    int temp = b[j] - f[i];
                    if (temp >= 0 && lowest > temp) {
                        ff[i] = j;
                        lowest = temp;
                    }
                }
            }

            frag[i] = lowest;
            bf[ff[i]] = 1;
            lowest = 1000;
        }

        System.out.println("\nFILE NO\t\tFILE SIZE\t\tBLOCK SIZE\t\tFRAGMENT");

        for(i = 1; i < nf && ff[i] != 0; ++i) {
            System.out.println(i + "\t\t\t" + f[i] + "\t\t\t" + ff[i] + "\t\t\t" + b[ff[i]] + "\t\t\t" + frag[i]);
        }

    }

    public static void firstFit() {
        int highest = 0;
        int max = 25;
        int[] frag = new int[max];
        int[] b = new int[max];
        int[] f = new int[max];
        int[] bf = new int[max];
        int[] ff = new int[max];
        Scanner input = new Scanner(System.in);
        System.out.println("---FIRST FIT TECHNIQUE---");
        System.out.println("\nEnter the number of blocks");
        int nb = input.nextInt();
        System.out.println("Enter the number of files");
        int nf = input.nextInt();
        System.out.println("Enter the size of blocks");

        int i;
        for(i = 1; i < nb; ++i) {
            System.out.println("Block: " + i);
            b[i] = input.nextInt();
        }

        System.out.println("Enter the size of files");

        for(i = 1; i < nf; ++i) {
            System.out.println("File: " + i);
            f[i] = input.nextInt();
        }

        for(i = 1; i < nf; ++i) {
            for(int j = 1; j < nb; ++j) {
                if (bf[j] != 1) {
                    int temp = b[j] - f[i];
                    if (temp >= 0 && highest < temp) {
                        ff[i] = j;
                        highest = temp;
                    }
                }
            }

            frag[i] = highest;
            bf[ff[i]] = 1;
            highest = 0;
        }

        System.out.println("\nFILE NO\t\tFILE SIZE\t\tBLOCK NO\t\tBLOCK SIZE\t\tFRAGMENT");

        for(i = 1; i < nf; ++i) {
            System.out.println(i + "\t\t\t" + f[i] + "\t\t\t" + ff[i] + "\t\t\t" + b[ff[i]] + "\t\t\t" + frag[i]);
        }

    }

    public static void firstComeFirstServe() {
        int[] bt = new int[20];
        int[] wt = new int[20];
        int[] tat = new int[20];

        Scanner input = new Scanner(System.in);

        System.out.println("\n~~WELCOME TO FIRST COME FIRST SERVE TECHNIQUE~~ ");
        
        System.out.println("\nEnter the number of processes~~ ");
        int n = input.nextInt();

        int i;
        for(i = 0; i < n; ++i) {
            System.out.println("\nEnter burst time for process ~~ " + i);
            bt[i] = input.nextInt();
        }

        float wtAvg = 0.0F;
        wt[0] = (int)0.0F;
        float tatAvg;
        tat[0] = (int)(tatAvg = (float)bt[0]);

        for(i = 1; i < n; ++i) {
            wt[i] = wt[i - 1] + bt[i - 1];
            tat[i] = tat[i - 1] + bt[i];
            wtAvg += (float)wt[i];
            tatAvg += (float)tat[i];
        }

        System.out.println("\nPROCESS \tBURST TIME \t WAITING TIME\t TURNAROUND TIME\n");

        for(i = 0; i < n; ++i) {
            System.out.println(i + "\t\t\t" + bt[i] + "\t\t\t\t" + wt[i] + "\t\t\t\t" + tat[i]);
        }

        System.out.println("\nAverage Waiting Time~~" + wtAvg / (float)n);
        System.out.println("\nAverage Turnaround Time~~" + tatAvg / (float)n);
    }

    public static void shortJobNext() {

        int[] p = new int[20];
        int[] bt = new int[20];
        int[] wt = new int[20];
        int[] tat = new int[20];
        Scanner input = new Scanner(System.in);

        System.out.println("\n~~WELCOME TO SHORT JOB NEXT TECHNIQUE~~ ");

        System.out.println("\nEnter the number of processes~~ ");
        int n = input.nextInt();

        int i;
        for(i = 0; i < n; ++i) {
            p[i] = i;
            System.out.println("Enter Burst Time for Process~~ " + i);
            bt[i] = input.nextInt();
        }

        for(i = 0; i < n; ++i) {
            for(int k = i + 1; k < n; ++k) {
                if (bt[i] > bt[k]) {
                    int temp = bt[i];
                    bt[i] = bt[k];
                    bt[k] = temp;
                    temp = p[i];
                    p[i] = p[k];
                    p[k] = temp;
                }
            }
        }

        float wtAvg = 0.0F;
        wt[0] = (int)0.0F;
        float tatAvg;
        tat[0] = (int)(tatAvg = (float)bt[0]);

        for(i = 1; i < n; ++i) {
            wt[i] = wt[i - 1] + bt[i - 1];
            tat[i] = tat[i - 1] + bt[i];
            wtAvg += (float)wt[i];
            tatAvg += (float)tat[i];
        }

        System.out.println("\nPROCESS \tBURST TIME \t WAITING TIME\t TURNAROUND TIME");

        for(i = 0; i < n; ++i) {
            System.out.println(p[i] + "\t\t\t\t" + bt[i] + "\t\t\t\t" + wt[i] + "\t\t\t\t" + tat[i]);
        }

        System.out.println("\nAverage Waiting Time~~ " + wtAvg / (float)n);
        System.out.println("\nAverage Turnaround Time~~" + tatAvg / (float)n);
    }

    public static void roundRobin() {
        float awt = 0.0F;
        float att = 0.0F;
        float temp = 0.0F;
        int[] bu = new int[10];
        int[] wa = new int[10];
        int[] tat = new int[10];
        int[] ct = new int[10];
        Scanner input = new Scanner(System.in);
        System.out.println("~~WELCOME TO ROUND ROBIN TECHNIQUE~~");
        System.out.println("\nEnter the no of processes~~ ");
        int n = input.nextInt();

        int i;
        for(i = 0; i < n; ++i) {
            System.out.println("\nEnter Burst Time for process~~ " + i);
            bu[i] = input.nextInt();
            ct[i] = bu[i];
        }

        System.out.println("\nEnter the size of time slice~~ ");
        int t = input.nextInt();
        int max = bu[0];

        for(i = 1; i < n; ++i) {
            if (max < bu[i]) {
                max = bu[i];
            }
        }

        for(int j = 0; j < max / t + 1; ++j) {
            for(i = 0; i < n; ++i) {
                if (bu[i] != 0) {
                    if (bu[i] <= t) {
                        tat[i] = (int)(temp + (float)bu[i]);
                        temp += (float)bu[i];
                        bu[i] = 0;
                    } else {
                        bu[i] -= t;
                        temp += (float)t;
                    }
                }
            }
        }

        for(i = 0; i < n; ++i) {
            wa[i] = tat[i] - ct[i];
            att += (float)tat[i];
            awt += (float)wa[i];
        }

        System.out.println("\nThe Average Turnaround time is~~" + att / (float)n);
        System.out.println("The Average Waiting time is~~ " + awt / (float)n);
        System.out.println("\nPROCESS\t BURST TIME \t WAITING TIME\tTURNAROUND TIME");

        for(i = 0; i < n; ++i) {
            System.out.println(i + 1 + "\t\t\t" + ct[i] + "\t\t\t\t" + wa[i] + "\t\t\t\t" + tat[i]);
        }

    }

    public static void priority() {
        int[] p = new int[20];
        int[] bt = new int[20];
        int[] pri = new int[20];
        int[] wt = new int[20];
        int[] tat = new int[20];
        Scanner input = new Scanner(System.in);
        System.out.println("~~~WELCOME TO PRIORITY TECHNIQUE~~~\n");
        System.out.println("Enter the number of processes~~ ");
        int n = input.nextInt();

        int i;
        for(i = 0; i < n; ++i) {
            p[i] = i;
            System.out.println("Enter the Burst Time~~ " + i);
            bt[i] = input.nextInt();
            System.out.println("Enter the priority Time~~ ");
            pri[i] = input.nextInt();
        }

        for(i = 0; i < n; ++i) {
            for(int k = i + 1; k < n; ++k) {
                if (pri[i] > pri[k]) {
                    int temp = p[i];
                    p[i] = p[k];
                    p[k] = temp;
                    temp = bt[i];
                    bt[i] = bt[k];
                    bt[k] = temp;
                    temp = pri[i];
                    pri[i] = pri[k];
                    pri[k] = temp;
                }
            }
        }

        float wtAvg = (float)(wt[0] = 0);
        float tatAvg = (float)(tat[0] = bt[0]);

        for(i = 1; i < n; ++i) {
            wt[i] = wt[i - 1] + bt[i - 1];
            tat[i] = tat[i - 1] + bt[i];
            wtAvg += (float)wt[i];
            tatAvg += (float)tat[i];
        }

        System.out.println("PROCESS\tPRIORITY\tBURST TIME\tWAITING TIME\tTURNAROUND TIME");

        for(i = 0; i < n; ++i) {
            System.out.println(p[i] + "\t\t\t" + pri[i] + "\t\t\t\t" + bt[i] + "\t\t\t" + wt[i] + "\t\t\t" + tat[i]);
        }

        System.out.println("\nAverage Waiting Time is~~ " + wtAvg / (float)n);
        System.out.println("\nAverage Turnaround Time is~~ " + tatAvg / (float)n);
    }

    public static void bankersAlgorithm() {
        int[] all = new int[10];
        int[] max = new int[10];
        int[] need = new int[10];
        boolean flag = false;
        int[] f = new int[10];
        int n = 0;
        int r = 0;
        boolean g = false;
        boolean cnt = false;
        int[] avail = new int[10];
        int[] seq = new int[10];
        Scanner input = new Scanner(System.in);
        System.out.println("~~WELCOME TO THE BANKERS ALGORITHM~~\n");
        System.out.println("~~This Algorithm was popularly used in Banks. They were used to make sure Banks didnt loan out more money than they had, and also made sure a customer couldn't borrow above his/her credit limit.\n ");
        System.out.println("Enter number of processes~~ ");

        boolean number;
        do {
            if (input.hasNextInt()) {
                n = input.nextInt();
                number = true;
                System.out.println("\nEnter number of resources -- ");
                r = input.nextInt();
            } else {
                System.out.println("Sorry,you cannot enter letters or fractions.\n");
                System.out.println("Enter whole numbers only~~ ");
                number = false;
                input.next();
            }
        } while(!number);

        int i;
        int j;
        for(i = 0; i < n; ++i) {
            System.out.println("\nEnter details for process~~ " + i);
            System.out.println("\nEnter allocation~~ ");

            for(j = 0; j < r; ++j) {
                all[j] = input.nextInt();
            }

            System.out.println("Enter Max\t\t -- \t");

            for(j = 0; j < r; ++j) {
                max[j] = input.nextInt();
            }

            flag = false;
        }

        System.out.println("\nEnter Available Resources\t -- \t");

        for(i = 0; i < r; ++i) {
            avail[i] = input.nextInt();
        }

        System.out.println("\nEnter New Request Details -- ");
        System.out.println("\nEnter pid \t -- \t");
        int id = input.nextInt();
        System.out.println("Enter Request for Resources \t -- \t");

        for(i = 0; i < r; ++i) {
            int newr = input.nextInt();
            all[i] += newr;
            avail[i] -= newr;
        }

        for(i = 0; i < n; ++i) {
            for(j = 0; j < r; ++j) {
                need[j] = max[j] - f[all[i]];
                if (need[j] < 0) {
                    need[j] = 0;
                }
            }
        }


        int fl = 0;

        while(cnt == false) {
            g = false;

            for(j = 0; j < n; ++j) {
                if (!flag) {
                    int b = 0;

                    for(int p = 0; p < r; ++p) {
                        if (avail[p] >= need[p]) {
                            ++b;
                        } else {
                            --b;
                        }
                    }

                    if (b == r) {
                        System.out.println(i + "is visited" + j);
                        seq[fl++] = j;
                        flag = true;

                        int k;
                        for(k = 0; k < r; ++k) {
                            avail[k] += all[k];
                        }


                        System.out.println("(");

                        for(k = 0; k < r; ++k) {
                            System.out.println("%3d" + avail[k]);
                        }

                        System.out.println(")");
                        g = true;
                    }
                }
            }

            if (!g) {
                System.out.println("\n REQUEST NOT GRANTED -- DEADLOCK OCCURRED");
                System.out.println("\n SYSTEM IS IN UNSAFE STATE");
            }
        }

        System.out.println("\nSYSTEM IS IN SAFE STATE");
        System.out.println("\nThe Safe Sequence is -- (");

        for(i = 0; i < fl; ++i) {
            seq[i] = input.nextInt();
        }

        System.out.println(")");
        System.out.println("\nProcess\t\tAllocation\t\tMax\t\t\tNeed\n");

        for(i = 0; i < n; ++i) {
            System.out.println("Process" + i);

            for(j = 0; j < r; ++j) {
                System.out.println(all[j]);
            }

            for(j = 0; j < r; ++j) {
                System.out.println(max[j]);
            }

            for(j = 0; j < r; ++j) {
                System.out.println(need[j]);
            }

            System.out.println("\n");
        }

    }

    public static void fcFs() {
        int n = 0;
        int tot = 0;
        int[] t = new int[20];
        int[] tohm = new int[20];
        Scanner input = new Scanner(System.in);

        boolean number;
        do {
            if (input.hasNextInt()) {
                System.out.println("Enter the no.of tracks");
                n = input.nextInt();
                number = true;
            } else {
                System.out.println("Sorry,you cannot enter letters or fractions.\n");
                System.out.println("Enter whole numbers only~~ ");
                number = false;
                input.next();
            }
        } while(!number);

        System.out.println("Enter the tracks to be traversed");

        int i;
        for(i = 2; i < n + 2; ++i) {
            t[i] = input.nextInt();
        }

        for(i = 1; i < n + 1; ++i) {
            tohm[i] = t[i + 1] - t[i];
            if (tohm[i] < 0) {
                tohm[i] *= -1;
            }
        }

        for(i = 1; i < n + 1; ++i) {
            tot += tohm[i];
        }

        float avHm = (float)tot / (float)n;
        System.out.println("Tracks traversed\tDifference between tracks\n");

        for(i = 1; i < n + 1; ++i) {
            System.out.println(" " + t[i] + "\t\t\t\t\t\t\t" + tohm[i]);
        }

        System.out.println("\nAverage header movements~~ " + avHm);
    }

    public static void scan() {
        int j = 0;
        int n = 0;
        int sum = 0;
        int[] t = new int[20];
        int[] d = new int[20];
        int[] atr = new int[20];
        Scanner input = new Scanner(System.in);

        boolean number;
        do {
            System.out.println("Enter the no of tracks to be traversed");
            if (input.hasNextInt()) {
                n = input.nextInt();
                number = true;
            } else {
                System.out.println("Sorry,you cannot enter letters or fractions.");
                System.out.println("Enter whole numbers only~~ ");
                number = false;
                input.next();
            }
        } while(!number);

        System.out.println("Enter the position of head");
        int h = input.nextInt();
        t[0] = 0;
        t[1] = h;
        System.out.println("Enter the tracks");

        int i;
        for(i = 2; i < n + 2; ++i) {
            t[i] = input.nextInt();
        }

        for(i = 0; i < n + 2; ++i) {
            for(j = 0; j < n + 2 - i - 1; ++j) {
                if (t[j] > t[j + 1]) {
                    int temp = t[j];
                    t[j] = t[j + 1];
                    t[j + 1] = temp;
                }
            }
        }

        for(i = 0; i < n + 2; ++i) {
            if (t[i] == h) {
                j = i;
            }
        }

        int k = i;

        int p;
        for(p = 0; t[j] != 0; ++p) {
            atr[p] = t[j];
            --j;
        }

        atr[p] = t[j];

        for(p = i + 1; p < n + 2; ++k) {
            atr[p] = t[k + 1];
            ++p;
        }

        for(j = 0; j < n + 1; ++j) {
            if (atr[j] > atr[j + 1]) {
                d[j] = atr[j] - atr[j + 1];
            } else {
                d[j] = atr[j + 1] - atr[j];
            }

            sum += d[j];
        }

        System.out.println("\nAverage header movements~~ " + (float)sum / (float)n);
    }

    public static void cScan() {
        int h = 0;
        int j = 0;
        int n = 0;
        int tot = 0;
        int sum = 0;
        int[] t = new int[20];
        int[] d = new int[20];
        int[] atr = new int[20];
        Scanner input = new Scanner(System.in);

        boolean number;
        do {
            if (input.hasNextInt()) {
                System.out.println("Enter the no of tracks to be traversed");
                n = input.nextInt();
                System.out.println("\nEnter the position of head");
                h = input.nextInt();
                t[0] = 0;
                t[1] = h;
                System.out.println("\nEnter total tracks");
                tot = input.nextInt();
                number = true;
            } else {
                System.out.println("Sorry,you cannot enter letters or fractions.\n");
                System.out.println("Enter whole numbers only~~ ");
                number = false;
                input.next();
            }
        } while(!number);

        t[2] = tot - 1;
        System.out.println("\nEnter the tracks");

        int i;
        for(i = 3; i <= n + 2; ++i) {
            t[i] = input.nextInt();
        }

        for(i = 0; i <= n + 2; ++i) {
            for(j = 0; j <= n + 2 - i - 1; ++j) {
                if (t[j] > t[j + 1]) {
                    int temp = t[j];
                    t[j] = t[j + 1];
                    t[j + 1] = temp;
                }
            }
        }

        for(i = 0; i <= n + 2; ++i) {
            if (t[i] == h) {
                j = i;
            }
        }

        int p;
        for(p = 0; t[j] != tot - 1; ++p) {
            atr[p] = t[j];
            ++j;
        }

        atr[p] = t[j];
        ++p;

        for(i = 0; p != n + 3 && t[i] != t[h]; ++p) {
            atr[p] = t[i];
            ++i;
        }

        for(j = 0; j < n + 2; ++j) {
            if (atr[j] > atr[j + 1]) {
                d[j] = atr[j] - atr[j + 1];
            } else {
                d[j] = atr[j + 1] - atr[j];
            }

            sum += d[j];
        }

        System.out.println("Total header movements is~~ " + sum);
        System.out.println("Average is~~ " + (float)sum / (float)n);
    }
}
