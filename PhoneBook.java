package buoi7_1;

import java.util.ArrayList;

import buoi7.PhoneEntry;

public class PhoneBook {

	private int numberofEntries = 0;
	
	ArrayList<PhoneEntry> listPe = new ArrayList<>();

	public boolean addEntry(PhoneEntry entry) {
		if (!isDuplicateName(entry.getName()) && !isDuplicateNumber(entry.getPhoneNumber())) {
			listPe.add(entry);
			numberofEntries++;
			return true;
		}
		else return false;
	}
	
	
	public boolean modifyEntryName(String oldName, String newName) {
		PhoneEntry pe = findEntryByName(oldName);
		if (pe != null && !isDuplicateName(newName)) {
			pe.setName(newName);
			return true;
		}
		return false;
	}
		
			
	public boolean modifyEntryNumber(String entryName, String newNumber) {
		PhoneEntry  pe1 = findEntryByName(entryName);
		if(pe1!= null && !isDuplicateNumber(newNumber)) {
			pe1.setPhoneNumber(newNumber);
			return true;
		}
		return false;
	}
	
	public boolean deleteEntry(String entryName) {
		for (int i = 0; i < numberofEntries; i++) {
			if (listPe.get(i).getName().equals(entryName)) {
				listPe.remove(entryName);
				return true;
			}
		}
		return false;
	}
	
	public PhoneEntry findEntryByName(String entryName) {
		for(int i = 0; i < numberofEntries; i++) {
			if(listPe.get(i).getName().equals(entryName)) {
				return listPe.get(i);
			}
		}
		return null;
	}
	
	public PhoneEntry findEntryByNumber(String entryNumber) {
		for(int i = 0; i < numberofEntries; i++) {
			if(listPe.get(i).getPhoneNumber().equals(entryNumber)) {
				return listPe.get(i);
			}
		}
		return null;
	}
	
	private boolean isDuplicateName(String entryName) {
		for(int i = 0; i < numberofEntries; i++) {
			if(listPe.get(i).getName().equals(entryName)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isDuplicateNumber(String entryNumber) {
		for(int i = 0; i < numberofEntries; i++) {
			if(listPe.get(i).getPhoneNumber().equals(entryNumber)) {
				return true;
			}
		}
		return false;
	}
	public String toString() {
		String all = "";
		for (int i = 0; i < numberofEntries; i++) {
			all += listPe.get(i).toString() + "\n";
		}
		return all;
	}
	
}
