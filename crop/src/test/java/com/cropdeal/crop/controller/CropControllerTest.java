package com.cropdeal.crop.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;

import com.cropdeal.crop.model.Crop;

@DisplayName("while running CropController")
class CropControllerTest {

	CropController cropControllerMock;
	TestInfo testInfo;
	TestReporter testReporter;

	@BeforeEach
	void init(TestInfo testInfo, TestReporter testReporter) {
		this.testInfo = testInfo;
		this.testReporter = testReporter;
		cropControllerMock = mock(CropController.class);
		testReporter.publishEntry("Running " + testInfo.getDisplayName());
	}

	@Test
	@DisplayName("while fetching all crops")
	void testViewCrops() {
		when(cropControllerMock.viewCrops()).thenReturn(Stream.of(new Crop("apple", "fruits", 30, 60, "red in colour"),
				new Crop("chana", "pulses", 48, 80, "yellow in colour")).collect(Collectors.toList()));
		assertEquals(2, cropControllerMock.viewCrops().size());
	}

	@Test
	@DisplayName("while fetching crop details")
	void testViewCrop() {
		Crop mockCrop = new Crop("apple", "fruits", 30, 60, "red in colour");

		when(cropControllerMock.viewCrop("618a0622c2b0874090aef7a8")).thenReturn(mockCrop);
		assertAll(() -> assertEquals("apple", mockCrop.getCrop_name()),
				() -> assertEquals("fruits", mockCrop.getCrop_tag()),
				() -> assertEquals(30, mockCrop.getCrop_quantity()),
				() -> assertEquals(60, mockCrop.getCrop_price()),
				() -> assertEquals("red in colour", mockCrop.getCrop_description()));
	}

	@Test
	@DisplayName("while adding crop details")
	void testAddCrop() {
		Crop mockCrop = new Crop("apple", "fruits", 30, 60, "red in colour");
		
		when(cropControllerMock.addCrop(mockCrop)).thenReturn(mockCrop);
		assertEquals(mockCrop,cropControllerMock.addCrop(mockCrop));
	}

	@Test
	@DisplayName("while updating crop details")
	void testUpdateCrop() {
		Crop crop1 = new Crop("apple", "fruits", 30, 60, "red in colour");
		Crop crop2 = new Crop("chana", "pulses", 40, 80, "yellow in colour");
		when(cropControllerMock.updateCrop(crop1, "618a0622c2b0874090aef7a8")).thenReturn(crop2);
		assertEquals(crop2,cropControllerMock.updateCrop(crop1, "618a0622c2b0874090aef7a8"));
	}

	@Test
	@DisplayName("while deleting crop details")
	void testDeleteCrop() {
		when(cropControllerMock.deleteCrop("618a0622c2b0874090aef7a8")).thenReturn("crop deleted 618a0622c2b0874090aef7a8");
		assertEquals("crop deleted 618a0622c2b0874090aef7a8",cropControllerMock.deleteCrop("618a0622c2b0874090aef7a8"));
	}
}
