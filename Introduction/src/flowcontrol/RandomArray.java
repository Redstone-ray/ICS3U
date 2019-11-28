package flowcontrol;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

//import java.util.List;
//import java.util.concurrent.ThreadLocalRandom;

public class RandomArray {

	public int getRandomList(List<Integer> list) {
		list.add(200);
		list.add(200);
		list.add(200);
		list.add(500);
		list.add(500);
		list.add(500);
		list.add(1000);
		list.add(1000);
		list.add(1000);
		list.add(2000);
		list.add(2000);
		list.add(5000);
		list.add(10000);
		// balance
		int index = ThreadLocalRandom.current().nextInt(list.size());
		return list.get(index);
	}

	public int getRandomAge(List<Integer> age) {
		age.add(16);
		age.add(18);
		age.add(20);
		age.add(24);
		age.add(27);
		age.add(30);
		// age
		int index = ThreadLocalRandom.current().nextInt(age.size());
		return age.get(index);
	}

	public int getRandomIQ(List<Integer> iq) {

		// IQ
		iq.add(30);
		iq.add(60);
		iq.add(100);
		iq.add(100);
		iq.add(120);
		iq.add(120);
		iq.add(120);
		iq.add(120);
		iq.add(140);
		iq.add(140);
		iq.add(160);
		iq.add(200);
		int index = ThreadLocalRandom.current().nextInt(iq.size());
		return iq.get(index);
	}
}
