package com.cropdeal.crop.service;

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

@DisplayName("while running CropService")
class CropServiceTest {
	
	CropServiceImpl cropServiceImplMock;
	TestInfo testInfo;
	TestReporter testReporter;
	
	@BeforeEach
	void init(TestInfo testInfo, TestReporter testReporter) {
		this.testInfo = testInfo;
		this.testReporter = testReporter;
		cropServiceImplMock = mock(CropServiceImpl.class);
		testReporter.publishEntry("Running "+ testInfo.getDisplayName());
	}
	
	@Test
	@DisplayName("while fetching all crops")
	void testViewCrops() {
		when(cropServiceImplMock.viewCrops()).thenReturn(Stream
                .of(new Crop("apple", "fruits", 30, 60, "red in colour"), new Crop("chana", "pulses", 48, 80, "yellow in colour"))
                .collect(Collectors.toList()));
        assertEquals(2, cropServiceImplMock.viewCrops().size());
	}
}
