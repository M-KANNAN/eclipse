package FamilyTree;

import java.util.Iterator;

public class Motherrelation {

	public void motherRelation(String mothersName) {
		
		
		String grandfather=FamilyMap.map.get(mothersName).fathersName;
		String grandmother=FamilyMap.map.get(mothersName).mothersName;
		
		
		Iterator<String> iterator=FamilyMap.map.keySet().iterator();
		while (iterator.hasNext()) {
			String brotherName = iterator.next();
			if(FamilyMap.map.get(brotherName).fathersName.equals(grandfather) && FamilyMap.map.get(brotherName).mothersName.equals(grandmother) && FamilyMap.map.get(brotherName).gender =='m' ) {
				this.brotherChildFinding(brotherName);
				break;
			}
			else {
				continue;
			}

		}	
		
	}

	private void brotherChildFinding(String brotherName ) {
		
		Iterator<String> iterator2=FamilyMap.map.keySet().iterator();
		while(iterator2.hasNext()) {
			String brotherchild=iterator2.next();
			if(FamilyMap.map.get(brotherchild).fathersName.equals(brotherName)  &&  FamilyMap.map.get(brotherchild).gender =='f' ) {
				System.out.println("motherrelation male");
				System.out.println(brotherchild);
			}
			else {
				continue;
			}
		}
		
	}

}
