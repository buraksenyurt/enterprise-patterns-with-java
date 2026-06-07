package SOLID.InterfaceSegregationCommon;

public class Customer extends Entity {

	private String title;
	private Long firmId;

	public Customer() {
	}

	public Customer(Long id, String title, Long firmId) {
		this.setId(id);
		this.title = title;
		this.firmId = firmId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getFirmId() {
		return firmId;
	}

	public void setFirmId(Long firmId) {
		this.firmId = firmId;
	}
}