enum ButtonOutlinedStyle {
    static func applyStyle(on button: UIButton) {
        ButtonStyle.applyStyle(on: button)
        applyStyleForStates(on: button)
        button.layer.borderWidth = 1
    }

    static func applyStyleForStates(on button: UIButton) {
        switch button.state {
        case .normal:
            button.layer.borderColor = NatColors.primary.cgColor
        case .disabled:
            button.layer.borderColor = NatColors.onSurface
                .withAlphaComponent(NatOpacities.low).cgColor
        default: break
        }
    }

    static func applyStyleForTitle(_ title: String, on button: UIButton) {
        ButtonStyle.applyStyleForTitle(
            title,
            colorForNormal: NatColors.onSurface,
            on: button
        )
    }
}
