package FamilyTree;

import java.util.Iterator;

public class Fatherrelation {
	
		void fatherRelation(String fathersName) {
			
			String grandfather=FamilyMap.map.get(fathersName).fathersName;
			String grandmother=FamilyMap.map.get(fathersName).mothersName;

			Iterator<String> iterator=FamilyMap.map.keySet().iterator();
			while (iterator.hasNext()) {
				String sisterName = iterator.next();
				if(FamilyMap.map.get(sisterName).fathersName.equals(grandfather) && FamilyMap.map.get(sisterName).mothersName.equals(grandmother)   &&  FamilyMap.map.get(sisterName).gender =='f' ) {
					this.sisterChildFinding(sisterName);
					break;
				}
				else {
					continue;
				}
			
			}
			
		}

		private void sisterChildFinding(String sisterName) {
			Iterator<String> iterator2=FamilyMap.map.keySet().iterator();
			while(iterator2.hasNext()) {
				String sisterchild=iterator2.next();
				if(FamilyMap.map.get(sisterchild).mothersName.equals(sisterName)  &&  FamilyMap.map.get(sisterchild).gender =='f' ) {
					System.out.println("FatherRelation male");
					System.out.println(sisterchild);
				}
				else {
					continue;
				}
			}
			
		}
		
	}

