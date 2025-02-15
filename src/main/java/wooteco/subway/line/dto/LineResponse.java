package wooteco.subway.line.dto;

import java.util.List;
import java.util.stream.Collectors;
import wooteco.subway.line.domain.Line;
import wooteco.subway.station.dto.StationResponse;

public class LineResponse {

    private Long id;
    private String name;
    private String color;
    private List<StationResponse> stations;
    private List<SectionResponse> sections;

    public LineResponse() {
    }

    public LineResponse(Long id, String name, String color, List<StationResponse> stations) {
        this(id, name, color, stations, null);
    }

    public LineResponse(Long id, String name, String color, List<StationResponse> stations,
        List<SectionResponse> sections) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.stations = stations;
        this.sections = sections;
    }

    public static LineResponse of(Line line) {
        List<StationResponse> stations = line.getStations().stream()
            .map(StationResponse::of)
            .collect(Collectors.toList());
        List<SectionResponse> sections = line.getSections().stream()
            .map(SectionResponse::of)
            .collect(Collectors.toList());
        return new LineResponse(line.getId(), line.getName(), line.getColor(), stations, sections);
    }

    public static List<LineResponse> listOf(List<Line> lines) {
        return lines.stream()
            .map(LineResponse::of)
            .collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public List<StationResponse> getStations() {
        return stations;
    }

    public List<SectionResponse> getSections() {
        return sections;
    }
}
