package com.hospital.admin.services;

import com.hospital.admin.domain.Hospital;
import com.hospital.admin.mappers.HospitalMapper;
import com.hospital.admin.model.DoctorDTO;
import com.hospital.admin.model.HospitalDTO;
import com.hospital.admin.model.PatientDTO;
import com.hospital.admin.model.SpecialityDTO;
import com.hospital.admin.repositories.HospitalRepository;
import lombok.var;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.lang.reflect.Type;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class HospitalService implements IHospitalServices {
    private final HospitalRepository _hospitalRepository;
    private ModelMapper modelMapper;
    @PersistenceContext
    private EntityManager em;

    public HospitalService(HospitalRepository hospitalRepository) {
        _hospitalRepository = hospitalRepository;
        modelMapper = new ModelMapper();
    }

    @Override
    public HospitalDTO getHospitalById(UUID id) {
        var patient = _hospitalRepository.findById(id);
        return patient.map(HospitalMapper::hospitalToHospitalDto).orElse(null);
    }

    @Override
    public HospitalDTO saveHospital(HospitalDTO hospitalDTO) {
        Hospital hospital = modelMapper.map(hospitalDTO, Hospital.class);
        hospital = _hospitalRepository.save(hospital);
        hospitalDTO.setId(hospital.getId());
        return hospitalDTO;
    }

    @Override
    public HospitalDTO updateHospital(HospitalDTO hospitalDTO) {
        var uuid = hospitalDTO.getId();
        Hospital hospital = _hospitalRepository.getOne(uuid);

        hospital.setName(hospitalDTO.getName());



        hospital = _hospitalRepository.save(hospital);

        return HospitalMapper.hospitalToHospitalDto(hospital);
    }

    @Override
    public void delete(UUID id) {
        Hospital hospital = _hospitalRepository.getOne(id);
        _hospitalRepository.delete(hospital);
    }

    @Override
    public List<HospitalDTO> GetHospitalList() {


        var result = _hospitalRepository.findAll();

        return
                result.stream()
                        .map(source -> modelMapper.map(source, HospitalDTO.class))
                        .collect(Collectors.toList());
    }

    public List<DoctorDTO> GetDoctorsByHospitalId(UUID uuid) {
        TypedQuery<Object[]> query = em.createQuery("select  d from Hospital h inner join HospitalDoctor hd on h.id=hd.HospitalId" +
                " inner join Doctor d on hd.DoctorId = d.id where h.id =?1", Object[].class);
        query.setParameter(1, uuid);
        List<Object[]> results = query.getResultList();
        Type listType = new TypeToken<List<DoctorDTO>>() {
        }.getType();
        return modelMapper.map(results, listType);
    }
    public List<SpecialityDTO> GetSpecialitiesByHospitalId(UUID uuid) {
        TypedQuery<Object[]> query = em.createQuery("select s from Hospital h inner join HospitalSpeciality hs on h.id=hs.HospitalId" +
                " inner join Speciality s on hs.SpecialityId = s.id where h.id =?1", Object[].class);
        query.setParameter(1, uuid);
        List<Object[]> results = query.getResultList();
        Type listType = new TypeToken<List<SpecialityDTO>>() {
        }.getType();
        return modelMapper.map(results, listType);
    }

    @Override
    public List<PatientDTO> GetPatientsByHospitalId(UUID uuid) {

        TypedQuery<Object[]> query = em.createQuery("select s from Hospital h inner join HospitalPatient hs on h.id=hs.HospitalId" +
                " inner join Patient s on hs.PatientId = s.id where h.id =?1", Object[].class);
        query.setParameter(1, uuid);
        List<Object[]> results = query.getResultList();
        Type listType = new TypeToken<List<PatientDTO>>() {
        }.getType();
        return modelMapper.map(results, listType);
    }
}
