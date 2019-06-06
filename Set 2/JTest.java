
/*
This isnt the most efficient sorting algorythm since it would
	require over 1,000,000 iterations vs like 5,000 in conventional
	sort algorythm.  Now if the numbers ranged like from 1 to 100
	and there were 100 of them (dups okay), well then it would be
	like 300 iterations, vs n^2/2 using other standard sort types
	like bubble, etc would be 5000 iterations or perhaps 2500 for
	binary???
*/
//import System.out.println;	// All static methods I guess?
import static java.lang.System.out;

public class JTest {

	public static void main(String[] args) {
		out.println("Short version");

		int[] DataArr = new int[100];
		//		int[] DataArr2 = new int[100];
		int[] BinArr = new int[1000000];
		int ASize = DataArr.length;

		for (int i = 0; i < ASize; i++) {
			DataArr[i] = (int) (Math.random() * 1000000); // Create an array of test data
			System.out.print("[" + i + "]=" + DataArr[i] + ", ");
			if (i % 5 == 0) {
				System.out.println();
			}

		}
		System.out.println("\n");
		// Now to sort the data
		for (int i = 0; i < ASize; i++) {
			BinArr[DataArr[i]]++; // Log # of occurences of number to sort
		}
		// Now to put it back into orig array
		int j = 0;
		int indexArr = 0;
		while (j < 1000000) {
			if (BinArr[j] > 0) {
				int tmpCnt = BinArr[j];
				do {
					DataArr[indexArr] = j;
					System.out.println("[" + (indexArr) + "]=" + DataArr[indexArr]);
					indexArr++;
					if (indexArr > ASize - 1) {
						break;
					}
					tmpCnt--;
				} while (tmpCnt > 0);
			}
			j++;

		}

	}
}