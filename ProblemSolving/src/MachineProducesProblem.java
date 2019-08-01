
import java.util.Arrays;

public class MachineProducesProblem {
	public static void main(String[] args) {
		long[] machineCapaciy = { 4, 5, 6 };
		long numberOfItemsToProduce = 12;
		long noOfDays = getNumberOfDaysToProduce(machineCapaciy, numberOfItemsToProduce);
		System.out.println("Number Of Days Taken >> " + noOfDays);
	}

	private static long getNumberOfDaysToProduce(long[] machineCapaciy, long numberOfItemsToProduce) {
		int noOfDays = 0;

		if (numberOfItemsToProduce <= 0 || machineCapaciy.length == 0) {
			return noOfDays;
		}
		long[] dayHolder = Arrays.copyOf(machineCapaciy, machineCapaciy.length);

		for (int i = 0; i < dayHolder.length; i++) {
			dayHolder[i]--;

			if (dayHolder[i] == 0) {
				dayHolder[i] = machineCapaciy[i];
				numberOfItemsToProduce--;
			}

			if (i == machineCapaciy.length - 1) {
				noOfDays++;
				i = -1;
			}

			if (numberOfItemsToProduce == 0) {

				if (i < machineCapaciy.length - 1 && i != -1) {
					noOfDays++;
				}
				break;
			}
		}
		return noOfDays;
	}

}
