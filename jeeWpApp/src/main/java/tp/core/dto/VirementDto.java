package tp.core.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class VirementDto {
		private Double montant;
		private Long numCptDeb;
		private Long numCptCred;
}
