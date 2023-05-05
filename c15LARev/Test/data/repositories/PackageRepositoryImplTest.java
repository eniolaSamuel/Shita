package data.repositories;

import shita.data.models.Package;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import shita.data.repositories.PackageRepository;

import static org.junit.jupiter.api.Assertions.*;

class PackageRepositoryImplTest {
    private PackageRepository packageRepository;

    @BeforeEach
    public void setUp(){
        packageRepository = new PackageRepositoryImpl();
    }


    @Test
    @DisplayName("Create New Package Test")
    public void saveOnePackage_countIsOneTest(){
        assertEquals(0, packageRepository.count());

        Package aPackage = new Package();
        packageRepository.save(aPackage);
        assertEquals(1, packageRepository.count());
    }

    @Test
    @DisplayName("Generate ID Test")
    public void saveOnePackage_IdIsOneTest(){
        Package aPackage =  new Package();
        assertEquals(0, aPackage.getId());

        Package savedPackage = packageRepository.save(aPackage);
        assertEquals(1, savedPackage.getId());
    }

    @Test
    @DisplayName("Find by ID Test")
    public void saveOnePackage_findPackageById_returnsSavedPackageTest(){
        Package aPackage = new Package();
        aPackage.setPayOnDelivery(true);
        packageRepository.save(aPackage);
        Package foundPackage = packageRepository.findById(1);
        assertTrue(foundPackage.isPayOnDelivery());
        assertEquals(1, foundPackage.getId());
        assertEquals(aPackage, foundPackage);
    }

    @Test
    @DisplayName("Update Test")
    public void saveTwoItemsWithSameId_countIsOneTest(){
        Package aPackage = new Package();
        aPackage.setWeight(76);
        Package savedAPackage = packageRepository.save(aPackage);
        assertEquals(aPackage, savedAPackage);

        Package secondPackage = new Package();
        secondPackage.setId(1);
        secondPackage.setWeight(67);
        packageRepository.save(secondPackage);

        Package foundPackage = packageRepository.findById(1);

        assertEquals(foundPackage,secondPackage);
        assertNotEquals(foundPackage, aPackage);
    }

    @Test
    @DisplayName("Delete Test")
    public void saveOnePackage_deleteOnePackage_countIsZeroTest(){
        Package aPackage = new Package();
        packageRepository.save(aPackage);
        assertEquals(1, packageRepository.count ());

        packageRepository.delete(1);
        assertEquals(0, packageRepository.count());
    }

    @Test
    public void saveThreeUsers_deleteOne_SaveAnother_checkCount(){
        Package aPackage1 = new Package();
        packageRepository.save(aPackage1);
        Package aPackage2 = new Package();
        packageRepository.save(aPackage2);
        Package aPackage3 = new Package();
        packageRepository.save(aPackage3);
        packageRepository.delete(3);
        Package aPackage4 = new Package();
        packageRepository.save(aPackage4);
        Package foundPackage = packageRepository.findById(3);
        assertNotEquals(aPackage3, foundPackage );
        assertEquals(3, packageRepository.count());
        assertEquals(4, aPackage4.getId());

    }


}