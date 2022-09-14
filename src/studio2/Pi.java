package studio2;

public class Pi {

	public static void main(String[] args) {

		double x = 0;
		double y = 0;
		double dist = 0;
		double outside = 0;
		double inside = 0;
		double areaPct = 0;
		int sims = 1000;
		
		for (int i = 0; i < sims; i++) {
			x = Math.random();
			y = Math.random();
			dist = Math.sqrt(Math.pow((x - 0.5), 2) + Math.pow((y - 0.5), 2));
			if(dist > 0.5) {
				outside++;
			} else {
				inside++;
			}
		}
		
		areaPct = inside / sims;
		System.out.println(areaPct / 0.25);
		
	}
}
