export interface ProductionRecord {
    id: string,
    plantsByHectare: number,
    podsByPlant: number,
    grainsByPod: number,
    weightByOneKGrains: number,
    productivity: number,
    commodity: {
        name: string,
        typeCommodity: string
    },
    createdDate: Date,
    lastModifiedDate: Date
}
